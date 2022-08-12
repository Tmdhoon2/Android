package com.example.memo.test

// 이벤트를 발생시키는 놈
class Counter(var listener: EventListener) {
    fun count(){
        for(i in 1..100){
            if (i%5 == 0){
                listener.onEvent(i)
            }
        }
    }
}

fun main(){
    EventPrinter().start()
}