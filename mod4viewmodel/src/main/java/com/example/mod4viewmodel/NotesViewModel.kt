package com.example.mod4viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel() : ViewModel() {
    private val _notes = MutableStateFlow<List<Double>>(emptyList())
    val notes : StateFlow<List<Double>> = _notes
    //private val _moyenne = MutableStateFlow<Double>(0.0)
    //val moyenne : StateFlow<Double> = _moyenne

    fun addNote(note: Double) {
        if(note < 0){
            throw IllegalArgumentException("Note must be positive")
        }else{
            _notes.value = _notes.value + note
            //_moyenne.value = _notes.value.average()
        }
    }
}