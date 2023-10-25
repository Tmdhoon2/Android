package com.untitled.roompractice.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.untitled.roompractice.database.DemoDatabase
import com.untitled.roompractice.entity.Recruitment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.Random

internal class MainViewModel(
    private val database: DemoDatabase,
) : ViewModel() {
    val mainState: MutableStateFlow<MainState> = MutableStateFlow(MainState())

    private val _mainSideEffect: MutableSharedFlow<MainSideEffect> = MutableSharedFlow()
    val mainSideEffect: SharedFlow<MainSideEffect> = _mainSideEffect.asSharedFlow()

    private val recruitmentDao by lazy {
        database.recruitmentDao()
    }

    fun onCompanyNameChange(
        companyName: CharSequence,
        start: Int,
        before: Int,
        count: Int,
    ) {
        Log.d("TEST", companyName.toString())
        viewModelScope.launch(Dispatchers.IO) {
            mainState.emit(mainState.value.copy(companyName = companyName.toString()))
        }
    }

    fun addRecruitment() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                recruitmentDao.addRecruitment(
                    Recruitment(
                        recruitmentId = mainState.value.recruitmentId + 1,
                        companyName = mainState.value.companyName,
                        trainPay = mainState.value.trainPay,
                        military = when (Random().nextInt(2)) {
                            0 -> false
                            else -> true
                        }
                    )
                )
            }.onSuccess {
                postSideEffect(MainSideEffect.Success)
            }.onFailure {
                postSideEffect(MainSideEffect.Failure(it.message.toString()))
            }
        }
    }

    fun onAddButtonClicked(view: View) {
        addRecruitment()
    }

    fun getRecruitments() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                recruitmentDao.getRecruitments()
            }.onSuccess {
                mainState.emit(mainState.value.copy(recruitmentId = it.size.toLong()))
                postSideEffect(MainSideEffect.SuccessGetRecruitments(it))
            }.onFailure {
                postSideEffect(MainSideEffect.Failure(it.message.toString()))
            }
        }
    }

    private suspend fun postSideEffect(sideEffect: MainSideEffect) {
        _mainSideEffect.emit(sideEffect)
    }
}

internal data class MainState(
    val companyName: String = "",
    val trainPay: Long = 0L,
    val recruitmentId: Long = 0L,
)

internal sealed class MainSideEffect {
    data object Success : MainSideEffect()
    class SuccessGetRecruitments(val recruitments: List<Recruitment>) : MainSideEffect()
    class Failure(val message: String) : MainSideEffect()
}