package com.example.pokemonlistapp.api

import com.example.pokemonlistapp.models.PokemonResponseItem
import com.example.pokemonlistapp.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getPokemon():Response<List<PokemonResponseItem>>
}