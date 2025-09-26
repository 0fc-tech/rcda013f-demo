package com.example.mod7retrofit.model

data class WeatherResponse(
    val hourly : HourlyData
)
data class HourlyData(
    val time : List<String>,
    val temperature_2m : List<Double>
)