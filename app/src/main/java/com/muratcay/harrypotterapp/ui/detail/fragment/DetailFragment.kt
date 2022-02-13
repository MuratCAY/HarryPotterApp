package com.muratcay.harrypotterapp.ui.detail.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.muratcay.harrypotterapp.R
import com.muratcay.harrypotterapp.databinding.FragmentDetailBinding
import com.muratcay.harrypotterapp.ui.base.BaseFragment
import com.muratcay.harrypotterapp.ui.detail.viewmodel.DetailViewModel
import com.muratcay.harrypotterapp.ui.factory.ViewModelFactory

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        val args = DetailFragmentArgs.fromBundle(requireArguments()).selectedCharacter
        val viewModelFactory = ViewModelFactory(args, requireActivity().application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
    }

    override fun getFragmentView(): Int = R.layout.fragment_detail
}