package com.example.yugiohdeckbuilder.data

import com.example.yugiohdeckbuilder.model.AllCardData
import com.example.yugiohdeckbuilder.model.CardData
import com.example.yugiohdeckbuilder.network.CardApiService

interface CardRepo {
    suspend fun getAllCardData(): AllCardData
    suspend fun getAllCardData2(): List<CardData>
}
class CardNetworkData
    (
        private val cardApiService: CardApiService
    ): CardRepo{
    override suspend fun getAllCardData(): AllCardData = cardApiService.getAllCardData()
    override suspend fun getAllCardData2(): List<CardData> = cardApiService.getAllCardData2()
}