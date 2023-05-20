package com.example.yugiohdeckbuilder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.yugiohdeckbuilder.R
import com.example.yugiohdeckbuilder.model.AllCardData
import com.example.yugiohdeckbuilder.model.CardData
import java.time.format.TextStyle

@Composable
fun HomeScreen(
    deckBuilderUiState: DeckBuilderUiState,
    modifier: Modifier = Modifier
){
    when(deckBuilderUiState){
        is DeckBuilderUiState.Loading -> LoadingScreen(modifier)
        is DeckBuilderUiState.Error-> ErrorScreen(modifier)
        is DeckBuilderUiState.Success -> CardDisplayer(cardData = deckBuilderUiState.data,modifier)
    }
}

@Composable
fun CardDisplayer(cardData: AllCardData, modifier: Modifier) {

    if(cardData.data != null){
        LazyColumn(modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(4.dp)){
            items(items = cardData.data,itemContent = {
                    card -> CardDisplay(card )
            })
        }
    }
}

@Composable
fun CardDisplay(cardData: CardData, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column() {
            AsyncImage(model = ImageRequest.Builder(context = LocalContext.current)
                .data(cardData.card_images?.get(0)?.imgUrlSmall)
                .crossfade(true)
                .build(),
                contentDescription = cardData.desc,
                //todo change these
                error = painterResource(R.drawable.ic_launcher_foreground),
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )

            cardData.name?.let { Text(text = it) }



        }
    }
}


@Composable
fun ErrorScreen(modifier: Modifier) {

    Text(text = "error")
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Text(text = "loading")
}
