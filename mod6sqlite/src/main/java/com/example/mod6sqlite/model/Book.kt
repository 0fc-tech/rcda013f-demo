package com.example.mod6sqlite.model

data class Book (
    val id: Long,
    val name: String,
    val isbn: String,
    val releaseDate: String,
    val editor:String,
    val author:String,
)