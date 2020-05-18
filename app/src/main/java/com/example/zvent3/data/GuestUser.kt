package com.example.zvent3.data

interface GuestUser {
    var guests : MutableList<Guest>

    fun initialize(){
        guests = mutableListOf(
            Guest("Alejandra Estévez", "45637829", "est@gmail.com"),
            Guest("Javier González", "45637829", "gon@gmail.com"),
            Guest("Mildred Sánchez", "45637829", "san@gmail.com"),
            Guest("Francisco Guerra", "45637829", "gue@gmail.com"),
            Guest("Priscilla Sandoval", "45637829", "san@gmail.com")
        )
    }
}