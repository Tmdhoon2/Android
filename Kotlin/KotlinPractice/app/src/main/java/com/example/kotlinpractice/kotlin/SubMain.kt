package com.example.kotlinpractice.kotlin

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터 넘겨줄 수가 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

val square = {number : Int -> number*number}

val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("씅훈", 17))
    val a = "씅훈 said"
    val b = "씅우 said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("씅훈", 17))

    println(calculateGrade(98))

    val lamda = {number : Double ->
        number == 4.3213
    }

    println(invokeLamda(lamda))
    println(invokeLamda{it > 3.22})

    invokeLamda { it > 3.22 }
}

// 확장함수

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String{

    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMyself(17)
}

// 람다의 Return

val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(5.1234)
}