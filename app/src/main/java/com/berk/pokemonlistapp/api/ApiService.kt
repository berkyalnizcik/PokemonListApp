package com.berk.pokemonlistapp.api

import com.berk.pokemonlistapp.models.PokemonResponseItem
import com.berk.pokemonlistapp.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getPokemon():Response<List<PokemonResponseItem>>
}