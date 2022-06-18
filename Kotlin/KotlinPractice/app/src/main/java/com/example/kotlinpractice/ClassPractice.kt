package com.example.kotlinpractice

class Human (val name : String = "Anonymous"){

    fun eatingCake(){
        println("this is so YUMMMYYY~~~~")
    }
}

fun main(){
    val human = Human("씅훈")

    val stranger = Human()
    human.eatingCake()

    println("this human's name is ${stranger.name}")

}