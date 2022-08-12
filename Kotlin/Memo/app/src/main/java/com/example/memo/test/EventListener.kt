package com.example.memo.test

// 발생시킨놈과 뿌려주는 놈을 이어주는 놈
interface EventListener {
    fun onEvent(count: Int)
}