package com.berk.pokemonlistapp.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.berk.pokemonlistapp.databinding.PokemonLayoutAdapterBinding
import com.berk.pokemonlistapp.models.PokemonResponseItem

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