package com.muratcay.harrypotterapp.ui.overview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.muratcay.harrypotterapp.data.model.CharacterModel

object DiffCallback : DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }
}