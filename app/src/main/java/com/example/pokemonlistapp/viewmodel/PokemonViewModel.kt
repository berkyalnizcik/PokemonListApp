package com.example.pokemonlistapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonlistapp.models.PokemonResponseItem
import com.example.pokemonlistapp.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel
@Inject constructor(private val repository: PokemonRepository) : ViewModel() {
    private val _response = MutableLiveData<List<PokemonResponseItem>>()
    val pokemonResponse: LiveData<List<PokemonResponseItem>>
        get() = _response

    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            repository.getPokemon().let { response ->
                if (response.isSuccessful) {
                    _response.postValue(response.body().orEmpty())
                } else {
                    Log.d("response", "error: ${response.code()}")
                }
            }
        }
    }
}

