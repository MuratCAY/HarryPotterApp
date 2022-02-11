package com.muratcay.harrypotterapp.ui.overview.fragment

import android.os.Bundle
import android.view.View
import com.muratcay.harrypotterapp.R
import com.muratcay.harrypotterapp.databinding.FragmentOverviewBinding
import com.muratcay.harrypotterapp.ui.base.BaseFragment
import com.muratcay.harrypotterapp.ui.overview.adapter.CharactersAdapter
import com.muratcay.harrypotterapp.ui.overview.viewmodel.OverviewViewModel

class OverviewFragment : BaseFragment<FragmentOverviewBinding>() {

    private val viewModel: OverviewViewModel by lazy { OverviewViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this         // dataBinding ile xml entegresi için kullanıldı
        binding.viewModel = viewModel           // xml de verdiğin variable name in tanımlaması

        binding.recyclerView.adapter = CharactersAdapter()
    }

    override fun getFragmentView(): Int = R.layout.fragment_overview
}