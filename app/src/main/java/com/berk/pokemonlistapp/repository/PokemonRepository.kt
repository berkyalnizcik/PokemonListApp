package com.berk.pokemonlistapp.repository

import com.berk.pokemonlistapp.api.ApiService
import javax.inject.Inject

class PokemonRepository
@Inject constructor(private val apiService: ApiService) {
    suspend fun getPokemon() = apiService.getPokemon()
}