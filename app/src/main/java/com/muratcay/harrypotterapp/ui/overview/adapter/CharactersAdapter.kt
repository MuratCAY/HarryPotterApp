package com.muratcay.harrypotterapp.ui.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muratcay.harrypotterapp.data.model.CharacterModel
import com.muratcay.harrypotterapp.databinding.ItemCharacterDesignBinding

class CharactersAdapter : ListAdapter<CharacterModel, CharactersAdapter.CharactersViewHolder>(DiffCallback) {

    var onClick: (CharacterModel) -> Unit = {}

    class CharactersViewHolder(private val binding: ItemCharacterDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterModel, onClick: (CharacterModel) -> Unit = {}) {
            binding.characterModel = character
            binding.executePendingBindings()    // bindingAdapter ı hızlı bir şekilde yapması için
            binding.root.setOnClickListener { onClick(character) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(ItemCharacterDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}