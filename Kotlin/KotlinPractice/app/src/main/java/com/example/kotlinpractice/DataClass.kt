package com.example.kotlinpractice

data class Ticket(val compnayName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val compnayName : String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreanAir", "Seunghoon Jung", "2023-05-18", 13)
    val ticketB = TicketNormal("koreanAir", "Seunghoon Jung", "2023-05-18", 13)

    println(ticketA)
    println(ticketB)
}