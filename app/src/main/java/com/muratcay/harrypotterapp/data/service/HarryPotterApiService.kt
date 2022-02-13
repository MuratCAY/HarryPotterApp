package com.muratcay.harrypotterapp.data.service

import com.muratcay.harrypotterapp.data.model.CharacterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface HarryPotterApiService {
    @GET("all_data.php")
    suspend fun getCharacters(): CharacterResponse

    @POST("filter_data.php")
    @FormUrlEncoded
    suspend fun filterCharacters(
        @Field("filter")
        filter: String
    ): CharacterResponse
}