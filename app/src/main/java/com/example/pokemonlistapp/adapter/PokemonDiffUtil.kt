package com.example.pokemonlistapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemonlistapp.models.PokemonResponseItem

class PokemonDiffUtil : DiffUtil.ItemCallback<PokemonResponseItem>() {

    override fun areItemsTheSame(
        oldItem: PokemonResponseItem,
        newItem: PokemonResponseItem
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: PokemonResponseItem,
        newItem: PokemonResponseItem
    ): Boolean {
        return oldItem == newItem
    }
}