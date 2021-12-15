package com.example.pokemonlistapp.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokemonlistapp.databinding.PokemonLayoutAdapterBinding
import com.example.pokemonlistapp.models.PokemonResponseItem

class PokemonViewHolder(val binding: PokemonLayoutAdapterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemonResponseItem: PokemonResponseItem) {
        binding.apply {
            textView.text = pokemonResponseItem.name
            imageView.load(pokemonResponseItem.imageurl) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}