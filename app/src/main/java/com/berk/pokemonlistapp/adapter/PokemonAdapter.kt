package com.berk.pokemonlistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonlistapp.databinding.PokemonLayoutAdapterBinding
import com.berk.pokemonlistapp.models.PokemonResponseItem

class PokemonAdapter(
    private val onClick: (PokemonResponseItem) -> Unit
) : ListAdapter<PokemonResponseItem, PokemonViewHolder>(PokemonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClick.invoke(getItem(adapterPosition))
                }
            }
        }
    }
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
