package com.example.kotlinpractice.kotlin//package com.example.kotlinpractice
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//open class Human (val name : String = "Anonymous"){
//
//    constructor(name : String, age : Int) : this(name){
//        println("my name is ${name}, ${age}years old")
//    }
//
//
//    init {
//        println("New human has been born!!")
//    }
//
//    fun eatingCake(){
//        println("This is so YUMMMYYY~~~~")
//    }
//
//    fun singASong(){
//        println("lalala")
//    }
//}
//
//class Korean : Human(){
//
//    override fun singASong(){
//        super.singASong()
//        println("라라랄")
//        println("my name is : ${name}")
//    }
//
//
//}
//
//
//
//
//
//
//fun main(){
//    val korean = Korean()
//    korean.singASong()
//}