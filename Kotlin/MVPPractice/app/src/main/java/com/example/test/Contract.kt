package com.example.test

interface Contract {

    interface View{
        fun showResult(answer: Int)
    }

    interface Presenter{
        fun addNum(num1 : Int, num2: Int)
    }
}