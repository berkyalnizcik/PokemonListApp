package com.berk.pokemonlistapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.berk.pokemonlistapp.R
import com.berk.pokemonlistapp.databinding.FragmentDetailsBinding
import com.berk.pokemonlistapp.models.PokemonResponseItem


class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var pokemon: PokemonResponseItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemon = args.pokemonDetail
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            textViewDetail.text = pokemon.name
            textViewDetail2.text = pokemon.category
            textViewDetail3.text = pokemon.typeofpokemon.toString()
            textViewDetail4.text = pokemon.hp.toString()
            textViewDetail5.text = pokemon.attack.toString()
            textViewDetail6.text = pokemon.defense.toString()
            textViewDetail7.text = pokemon.weaknesses.toString()
            imageViewDetail.load(pokemon.imageurl) {
                crossfade(true)
                crossfade(1000)
            }
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}