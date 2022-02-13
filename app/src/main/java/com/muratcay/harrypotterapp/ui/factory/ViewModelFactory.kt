package com.muratcay.harrypotterapp.ui.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muratcay.harrypotterapp.data.model.CharacterModel
import com.muratcay.harrypotterapp.ui.detail.viewmodel.DetailViewModel

// Constructor içerisine context veya application tanımlamamız gerektiği durumlarda factory'i kullanıyoruz

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val characterModel: CharacterModel, private val application: Application) : ViewModelProvider
.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(characterModel, application) as T
        }
        throw IllegalArgumentException("Invalid ViewModel")
    }
}