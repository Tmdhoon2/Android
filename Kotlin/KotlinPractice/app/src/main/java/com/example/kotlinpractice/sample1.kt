//package com.example.kotlinpractice
//
//import java.lang.IllegalArgumentException
//
//fun main(){
//    nullcheck()
//}
//
//// 4. 조건식
//
//fun maxBy(a : Int, b : Int) : Int{
//    if(a>b){
//        return a
//    }else{
//        return b
//    }
//}
//
//fun maxBy2(a: Int, b: Int) = if(a>b) a else b                       // 삼항 연산자
//
//fun checkNum(score : Int){
//    when(score){                                                    // when (switch case)
//        0 -> println("this is 0")
//        1 -> println("this is 1")
//        2,3 -> println("this is 2 or 3")
//        else -> println("I don't know")
//    }
//
//    var b = when(score){
//        1 -> 1
//        2 -> 2
//        else -> 3
//    }
//
//    when(score){
//        in 90..100 -> println("A")
//        in 80..89 -> println("B")
//        in 70..79 -> println("C")
//        else -> println("F")
//    }
//}
//
//// Expression vs Statement
//
//// 5. Array and List
//
//// Array
//
//// List 1. InMutableList 2. MutableList
//
//fun array(){
//    val array = arrayOf(1,2,3)
//    val list = listOf(1,2,3)
//
//    val array2 = arrayOf(1, "d", 3.4f)
//    val list2 = listOf(1, "d", 11L)
//
//    array[0] = 3
//    var result = list.get(0)
//
//    var arrayList = arrayListOf<Int>()
//    arrayList.add(10)
//    arrayList.add(20)
//}
//
//// 6. For / While
//
//fun forAndWhile(){
//
//    val students = arrayListOf("Jenny", "Rose", "Jisoo", "Lisa")
//
//    for(name in students){
//        println("${name}")
//    }
//
//    for((index, name) in students.withIndex()){
//        println("${index+1}번째 학생 : ${name}")
//    }
//
//    var sum : Int = 0
//    for(i in 1..10){
//        sum += i
//    }
//    println(sum)
//
//    var index = 0
//    while(index < 10){
//        println("current index : ${index}")
//        index++
//    }
//}
//
//// 7. Nullable / NonNull
//
//fun nullcheck(){
//    //NPE : Null pointer Exception
//
//    var name = "씅훈"
//
//    var nullName : String? = null
//
//    var nameInUpperCase = name.toUpperCase()
//
//    var nullNameInUpperCase = nullName?.toUpperCase()
//
//    // ?:
//
//    val lastName : String? = "Jung"
//
//    val fullName = name+ "" + (lastName?: "No lastName")
//
//    var mLastName = lastName ?: throw IllegalArgumentException("No last name")
//
//    println(fullName)
//}
//
//fun ignoreNulls(str : String?){
//    val mNotNull : String = str!!
//    val upper = mNotNull.toUpperCase()
//
//    val email : String? = "hks026naver@gmail.com"
//    email?.let {
//        println("my email is ${it}")
//    }
//}