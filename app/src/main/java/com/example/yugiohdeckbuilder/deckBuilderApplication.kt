package com.example.yugiohdeckbuilder

import android.app.Application
import com.example.yugiohdeckbuilder.data.AppContainer
import com.example.yugiohdeckbuilder.data.DefaultAppContainer

class DeckBuilderApplication: Application(){
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}