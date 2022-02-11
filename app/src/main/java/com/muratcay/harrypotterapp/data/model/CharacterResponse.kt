package com.muratcay.harrypotterapp.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("harrypotter")
    val characters: List<CharacterModel>,
    @SerializedName("success")
    val success: Int
)