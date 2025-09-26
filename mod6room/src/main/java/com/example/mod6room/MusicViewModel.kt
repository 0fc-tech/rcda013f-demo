package com.example.mod6room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicViewModel(private val dao: MusicDao): ViewModel() {
    private val _musics = MutableStateFlow<List<Music>>(emptyList())
    val musics: StateFlow<List<Music>> = _musics

    init {
        viewModelScope.launch(Dispatchers.IO) {
            insertMusic(
                Music(0L, "Never Gonna Give You Up", "Rick Astley", 220)
            )
            insertMusic(
                Music(0L, "Feel Good", "Polo & Pan", 240)
            )
            loadMusics()
        }
    }
    suspend fun loadMusics() {
            _musics.value = dao.getAllMusics()

    }

    suspend fun insertMusic(music: Music) {
            dao.insertMusic(music)

    }
    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val context = this[APPLICATION_KEY]?.applicationContext
                MusicViewModel(AppDatabase.getInstance(context!!).musicDao())
            }
        }
    }
}