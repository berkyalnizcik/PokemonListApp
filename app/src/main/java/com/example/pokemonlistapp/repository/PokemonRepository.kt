package com.example.pokemonlistapp.repository

import com.example.pokemonlistapp.api.ApiService
import javax.inject.Inject

class PokemonRepository
@Inject constructor(private val apiService: ApiService) {
    suspend fun getPokemon() = apiService.getPokemon()
}