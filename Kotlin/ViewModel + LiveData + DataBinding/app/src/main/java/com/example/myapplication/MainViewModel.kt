package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class actionType{
    UP, DOWN
}

class MainViewModel : ViewModel() {

    private val _currentValue = MutableLiveData<Int>()
    private val _currentValue2 = MutableLiveData<Int>()

    val currentValue : LiveData<Int>
    get() = _currentValue
    val currentValue2 : LiveData<Int>
    get() = _currentValue2

    init {
        _currentValue.value = 0
        _currentValue2.value = 0
    }

    fun updateValue(type : Int){
        when(type){
            1 ->
                _currentValue.value = _currentValue.value?.plus(1)
            2 ->
                _currentValue.value = _currentValue.value?.minus(1)
        }
    }

    fun setValue(){
        _currentValue2.value = _currentValue.value
    }

}