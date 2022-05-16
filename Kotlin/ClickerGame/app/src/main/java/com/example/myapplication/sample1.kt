package com.example.myapplication

fun main(){

    //3. String Template

    val name = "Seung"
    val lastName = "hoon"
    println("my name is ${name + lastName}'m 17")

    println("it shit true? ${1==0}))")
    println("this is 2\$a")
}

//4. 조건식

fun maxBy(a:Int, b:Int):Int{

    if(a>b){
        return a
    }else{
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if(a>b) a else b

//1. 함수

fun helloWorld() {
    println("Hello World!")
}

fun add(a : Int, b : Int) : Int {
    return a+b
}

//2. val vs var
//val = value

fun hi(){

    val a = 10
    var b = 9

    var e : String

    b = 100

    val c = 100
    var d = 100
    var name = "Seung"




}