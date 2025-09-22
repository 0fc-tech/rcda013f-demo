package com.example.mod4viewmodel_vendredi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel : ViewModel(){
    private val _notes = MutableStateFlow<List<Double>>(emptyList())
    val notes: StateFlow<List<Double>> = _notes

    fun addNote(note: Double) {
        _notes.value = _notes.value + note
    }
}