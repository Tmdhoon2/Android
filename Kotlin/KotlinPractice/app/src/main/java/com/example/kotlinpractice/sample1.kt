package com.example.kotlinpractice

import java.lang.IllegalArgumentException

fun main() {
    array()
}

fun maxBy(a : Int, b : Int) : Int{
    if(a>b){
        return a
    }else {
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if(a>b) a else b

fun checkNum(score : Int){
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
    }

    var b = when(score){
        1->1
        2->2
        else ->3
    }

    println("b : ${b}")

    when(score){
        in 90..100-> println("Your are genius")
        in 10..80-> println("not bad")
        else -> println("okay")
    }
}

// Expression vs Statement

// 5. Array and List

// Array

// List 1. List 2. MutableList

fun array(){
//    val array = arrayOf(1,2,3)
//    val list = listOf(1,2,3)
//
//    val array2 = arrayOf(1,"d",3.4f)
//    val list2 = listOf(1,"d",11L)
//
//    array[0] = 3
//    var result = list.get(0)
//
//    val arrayList = arrayListOf<Int>()
//    arrayList.add(10)
//    arrayList.add(20)
//    arrayList[0] = 20

    val playList = arrayOf(1,2,3)
    println(playList[1])
}

// 6. For / While

fun forAndWhile(){

    val students = arrayListOf("Yongsu", "Geunwoo", "Seungjae", "Seunghoon")

    for(name in students){
        println("${name}")
    }

    for ((index,name) in students.withIndex()){
        println("${index}번째 학생 : ${name}")
    }


    var sum : Int = 0
    for(i in 1..100){
        sum += i
    }
    println(sum)

    var index = 0
    while(index < 10){
        println("current index :  ${index}")
        index++
    }
}

// 7.Nullable / NonNull

fun nullcheck(){
    //NPE : NUll pointer Exception

    var name : String = "Seunghoon"

    var nullName : String? = null

    var nameInUpperCase = name.toUpperCase()

    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?:

    val lastName : String? = "Jung"

    val fullName = name+" "+ (lastName?:"NO lastName")

    var mLastName = lastName ?: throw IllegalArgumentException("NO last Name")

    println(fullName)

}

fun ignoreNulls(str : String?){
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()

    val email : String?= "hks026naver@gmail.com"
    email?.let{
        println("my eamil is ${email}")
    }
}




























