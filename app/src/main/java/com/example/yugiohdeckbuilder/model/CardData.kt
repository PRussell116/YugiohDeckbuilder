package com.example.yugiohdeckbuilder.model

data class CardData(
    val id: Int?,
    val name:String?,
    val type: String?,
    val frameType:String?,
    val desc: String?,
    val atk: Int?,
    val def: Int?,
    val level: Int?,
    val race: String?,
    val attribute: String?,
    val card_Sets: List<CardSets>?,
    val card_images: List<CardImages>?,
    val card_prices:List<CardPrices>?

)
