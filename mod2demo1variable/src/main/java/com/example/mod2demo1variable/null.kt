package com.example.mod2demo1variable


fun main() {

    //pas possible
    //var mot : String = null

    var mot2 : String? = null
    mot2?.length
    println(mot2)

    //inférence de type donc null accepté
    var mot3 = null
    println(mot3)
}

