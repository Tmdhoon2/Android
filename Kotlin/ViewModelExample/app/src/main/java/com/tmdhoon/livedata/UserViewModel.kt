package com.tmdhoon.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel() : ViewModel() {
    // height 값을 관찰 가능한 데이터로 만들어줌
    // 수정 가능
    private var _height = MutableLiveData<Int>()

    // 수정 불가능한 라이브 데이터
    val height: LiveData<Int>
    // kotlin getter
    get() = _height

    // 생성자
    init {
        _height.value = 170
    }

    // height 증가 함수
    fun increase(){
        _height.value = _height.value?.plus(1)
    }

}