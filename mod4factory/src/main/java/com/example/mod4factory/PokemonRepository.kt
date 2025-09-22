package com.example.mod4factory

class PokemonRepository {
    private val _pokemons =
        listOf("Pikachu", "Dracofeu", "Bulbizzare", "Rondoudou", "Tortank")

    fun getPokemons(): List<String> {
        return _pokemons
    }

}