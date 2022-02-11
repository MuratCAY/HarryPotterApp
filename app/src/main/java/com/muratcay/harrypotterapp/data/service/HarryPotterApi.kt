package com.muratcay.harrypotterapp.data.service

import com.muratcay.harrypotterapp.data.network.HarryPotterRetrofitInstance

object HarryPotterApi {
    private val retrofit = HarryPotterRetrofitInstance.getHarryPotterRetrofitClient()
    val retrofitService: HarryPotterApiService by lazy {
        retrofit.create(HarryPotterApiService::class.java)
    }
}
