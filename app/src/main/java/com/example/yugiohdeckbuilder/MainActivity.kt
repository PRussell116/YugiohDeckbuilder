package com.example.yugiohdeckbuilder

import android.os.Bundle
import android.text.Editable.Factory
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yugiohdeckbuilder.ui.CardApp
import com.example.yugiohdeckbuilder.ui.screens.DeckBuilderViewModel
import com.example.yugiohdeckbuilder.ui.theme.YugiohDeckBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YugiohDeckBuilderTheme {
                val viewModel : DeckBuilderViewModel = viewModel(factory = DeckBuilderViewModel.Factory)
                CardApp()

            }
        }
    }
}



