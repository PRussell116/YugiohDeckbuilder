package com.example.yugiohdeckbuilder.model

import com.google.gson.annotations.SerializedName

data class CardImages(
    val id : Int?,
    @SerializedName("image_url") val imgUrl: String?,
    @SerializedName("image_url_small") val imgUrlSmall : String?,
    @SerializedName("image_url_cropped") val imgUrlCropped: String?,
)
