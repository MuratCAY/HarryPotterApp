package com.muratcay.harrypotterapp.ui.detail.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.muratcay.harrypotterapp.data.model.CharacterModel

class DetailViewModel(character: CharacterModel, application: Application) : AndroidViewModel(application) {

    private val mutableSelectedCharacter: MutableLiveData<CharacterModel> = MutableLiveData()
    val selectedCharacter: LiveData<CharacterModel>
        get() = mutableSelectedCharacter

    init {
        mutableSelectedCharacter.value = character
    }

}