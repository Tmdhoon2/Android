package com.example.koinpractice

/*
예제 클래스들을 정의해놓은 Model
 */

class AA{
    fun name() : String = "AA"
}

class BB(aa : AA){
    fun name() : String = "BB"
}