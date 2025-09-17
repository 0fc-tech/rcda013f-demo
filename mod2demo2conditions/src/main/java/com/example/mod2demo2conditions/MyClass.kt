package com.example.mod2demo2conditions

fun main() {
    val customerLivingFrance = true
    val customerLivingNl = false
    val shippingCost = if(customerLivingFrance)
        5
    else if(customerLivingNl)
        8
    else 78
    val harry = Film("Harry",false);
}


class Film(nom:String,vu:Boolean)