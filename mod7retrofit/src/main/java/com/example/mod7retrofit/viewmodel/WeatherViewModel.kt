package com.example.mod7retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mod7retrofit.model.HourlyData
import com.example.mod7retrofit.model.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weather = MutableStateFlow<HourlyData?>(null)
    val weather : StateFlow<HourlyData?> = _weather
    init {
        fetchWeather()
    }
    fun fetchWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = RetrofitClient.weatherApiService.getWeaterData(
                48.0373,
                -1.698,
                "temperature_2m",
                "temperature_2m"
            ).hourly
        }
    }
}