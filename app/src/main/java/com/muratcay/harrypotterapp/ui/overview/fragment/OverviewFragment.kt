package com.muratcay.harrypotterapp.ui.overview.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import com.muratcay.harrypotterapp.R
import com.muratcay.harrypotterapp.databinding.FragmentOverviewBinding
import com.muratcay.harrypotterapp.ui.base.BaseFragment
import com.muratcay.harrypotterapp.ui.overview.adapter.CharactersAdapter
import com.muratcay.harrypotterapp.ui.overview.viewmodel.OverviewViewModel
import com.muratcay.harrypotterapp.util.ApiMenuFilter

class OverviewFragment : BaseFragment<FragmentOverviewBinding>() {

    private val viewModel: OverviewViewModel by lazy { OverviewViewModel() }
    private val charactersAdapter: CharactersAdapter by lazy { CharactersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this         // dataBinding ile xml entegresi için kullanıldı
        binding.viewModel = viewModel           // xml de verdiğin variable name in tanımlaması

        binding.recyclerView.adapter = charactersAdapter

        sendDataAdapter()

        setHasOptionsMenu(true)
    }

    private fun sendDataAdapter() {

        charactersAdapter.onClick = {
            viewModel.displayCharacterDetails(it)
        }

        viewModel.navigateSelectedCharacter.observe(viewLifecycleOwner) { characterModel ->
            characterModel?.let {
                findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayCharacterDetailComplete()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.filterCharacters(
            when (item.itemId) {
                R.id.show_gryffindor -> ApiMenuFilter.SHOW_GRYFFINDOR
                R.id.show_hufflepuff -> ApiMenuFilter.SHOW_HUFFLEPUFF
                R.id.show_ravenclaw -> ApiMenuFilter.SHOW_RAVENCLAW
                R.id.show_slytherin -> ApiMenuFilter.SHOW_SLYTHERIN
                else -> throw IllegalArgumentException("Unknown overflow menu")
            }
        )
        return true
    }

    override fun getFragmentView(): Int = R.layout.fragment_overview
}