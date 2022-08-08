package com.example.kotlinpractice.kotlin

val intData: Int = 10
val result = intData.minus(5)

fun main(args: Array<String>){
    println(cases(1))
    println(cases(10))
}
val str2 = "Hello \n World"
val str3 = """Hello
World"""

fun cases(obj:Any) : String{
    when(obj){
        1 -> return "One"
        "Hello" -> return "Greeting"
        is Long -> return "Long"
        !is String -> return "Not a String"
        else -> return "unknown"
    }
}