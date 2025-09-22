package com.example.mod4factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PokemonViewModel(pokemonRepository: PokemonRepository): ViewModel() {
    private val _pokemons = MutableStateFlow<List<String>>(emptyList())
    val pokemons : StateFlow<List<String>> = _pokemons
    init{
        _pokemons.value = pokemonRepository.getPokemons()
    }
    companion object {
        @Suppress("UNCHECKED_CAST")
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PokemonViewModel(PokemonRepository()) as T;
            }
        }
    }

}