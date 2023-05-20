package com.example.yugiohdeckbuilder.data
import com.example.yugiohdeckbuilder.network.CardApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer{
    val cardRepo : CardRepo
}
class DefaultAppContainer: AppContainer{
    private val BASE_URL = "https://db.ygoprodeck.com/"
    private val retrofit = Retrofit.Builder()

        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: CardApiService by lazy{
        retrofit.create(CardApiService::class.java)
    }
    override val cardRepo: CardRepo by lazy {
        CardNetworkData(retrofitService)

    }

}