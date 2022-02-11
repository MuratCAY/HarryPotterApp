package com.muratcay.harrypotterapp.data.service

import com.muratcay.harrypotterapp.data.model.CharacterResponse
import retrofit2.http.GET

interface HarryPotterApiService {
    @GET("all_data.php")
    suspend fun getCharacters(): CharacterResponse
}