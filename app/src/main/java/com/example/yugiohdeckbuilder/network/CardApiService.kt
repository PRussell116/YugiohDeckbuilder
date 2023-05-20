package com.example.yugiohdeckbuilder.network

import com.example.yugiohdeckbuilder.model.AllCardData
import com.example.yugiohdeckbuilder.model.CardData
import retrofit2.http.GET

interface CardApiService{
    @GET("api/v7/cardinfo.php/?name=Dark Magician")
    suspend fun getAllCardData(): AllCardData
    @GET("api/v7/cardinfo.php/")
    suspend fun getAllCardData2(): List<CardData>
}