package com.example.mod2demo1variable

fun main() {

    var mot = "World !"

    val message by lazy { "Hello $mot" }

    // println(message)

    mot = "Man !"

    println(message)
}
