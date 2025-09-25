package com.example.mod6datastore

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SettingsViewModel(
    private val userPreferencesRepository: UserPreferencesRepository): ViewModel(){

    private val _colors = MutableStateFlow(listOf<Color>(
      Color.Red, Color.Green, Color.Blue,
      Color.Yellow, Color.Magenta, Color.LightGray,
    ))
    val colors : StateFlow<List<Color>> = _colors
    private val _userColor = MutableStateFlow(Color.White)
    val userColor : StateFlow<Color> = _userColor
    init {getBgColor()}

    fun getBgColor(){
        viewModelScope.launch {
            userPreferencesRepository.getBgColor().collect { colorsSelected -> _userColor.value = colorsSelected }
        }
    }
    fun setBgColor(color: Color){
        viewModelScope.launch {
            userPreferencesRepository.saveBgColor(color)
        }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val context = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]?.applicationContext
                val userRepository = UserPreferencesRepository(context!!)
                SettingsViewModel(userRepository)
            }
        }
    }

}