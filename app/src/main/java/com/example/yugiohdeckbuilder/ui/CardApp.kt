package com.example.yugiohdeckbuilder.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yugiohdeckbuilder.ui.screens.DeckBuilderViewModel
import com.example.yugiohdeckbuilder.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardApp(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {})
    {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            val deckBuilderViewModel: DeckBuilderViewModel = viewModel(factory = DeckBuilderViewModel.Factory)
            HomeScreen(deckBuilderUiState = deckBuilderViewModel.deckBuilderUiState)

        }

    }
}