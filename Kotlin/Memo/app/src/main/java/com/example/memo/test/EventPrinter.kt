package com.example.memo.test

// 발생한 이벤트를 수신해서 뿌려주는 놈
class EventPrinter {
    fun start(){
        val counter = Counter(object: EventListener{
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })
        counter.count()
    }
}