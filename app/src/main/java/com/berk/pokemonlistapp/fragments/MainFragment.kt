package com.berk.pokemonlistapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonlistapp.R
import com.berk.pokemonlistapp.adapter.PokemonAdapter
import com.example.pokemonlistapp.databinding.FragmentMainBinding
import com.berk.pokemonlistapp.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PokemonViewModel by viewModels()
    private lateinit var pokemonAdapter: PokemonAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    private fun setUpRv() {
        pokemonAdapter = PokemonAdapter {
            val direction = MainFragmentDirections.actionMainFragmentToDetailsFragment(it)
            findNavController().navigate(direction)
        }
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = pokemonAdapter
        }
        viewModel.pokemonResponse.observe(requireActivity(), { response ->
            pokemonAdapter.submitList(response)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}