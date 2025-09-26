package com.example.mod7retrofit.model

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    suspend fun getWeaterData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("current") current:String,
        @Query("hourly") hourly: String
    ) : WeatherResponse
}
