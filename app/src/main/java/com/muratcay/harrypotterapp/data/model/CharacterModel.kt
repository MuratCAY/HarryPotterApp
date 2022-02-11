package com.muratcay.harrypotterapp.data.model


import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("house")
    val house: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name") 
    val name: String
)