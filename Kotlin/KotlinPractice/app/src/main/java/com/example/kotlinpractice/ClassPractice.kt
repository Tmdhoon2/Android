package com.example.kotlinpractice


open class Human constructor(val name : String = "Anonymous"){

    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age}years old")
    }

    init{
        println("New human has been born!!")
    }

    fun eatingCake(){
        println("This is so YUMMYYYY~~~~")
    }

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human(){

    override fun singASong(){
        println("라라랄")
    }
}



fun main(){
    var playList = arrayOf(1,2)
}
