package com.muratcay.harrypotterapp.ui.overview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratcay.harrypotterapp.data.model.CharacterModel
import com.muratcay.harrypotterapp.data.service.HarryPotterApi
import com.muratcay.harrypotterapp.util.Status
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val mutableStatus: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status>
        get() = mutableStatus

    private val mutableCharacters: MutableLiveData<List<CharacterModel>> = MutableLiveData()
    val character: LiveData<List<CharacterModel>>
        get() = mutableCharacters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {

            mutableStatus.value = Status.LOADING

            try {
                mutableCharacters.value = HarryPotterApi.retrofitService.getCharacters().characters
                mutableStatus.value = Status.DONE
            } catch (e: Exception) {
                mutableStatus.value = Status.ERROR
                mutableCharacters.value = ArrayList()
            }
        }
    }

}