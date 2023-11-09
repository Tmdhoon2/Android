package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivityViewModel : ViewModel() {
    init {
        test()
    }

    private fun test() {
        viewModelScope.launch {
            repeat(10000) {
                Log.d("TEST", it.toString())
                delay(1000)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TEST", "onCleared")
    }
}