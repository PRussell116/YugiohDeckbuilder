package com.example.yugiohdeckbuilder.ui.screens

import android.text.Editable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.yugiohdeckbuilder.DeckBuilderApplication
import com.example.yugiohdeckbuilder.data.CardRepo
import com.example.yugiohdeckbuilder.model.AllCardData
import com.example.yugiohdeckbuilder.model.CardData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface DeckBuilderUiState{
//    data class Success(val data:AllCardData):DeckBuilderUiState
    data class Success(val data: AllCardData) :DeckBuilderUiState
    object Error: DeckBuilderUiState
    object Loading:DeckBuilderUiState
}

class DeckBuilderViewModel(private val repo: CardRepo):ViewModel() {
    var deckBuilderUiState: DeckBuilderUiState by mutableStateOf(DeckBuilderUiState.Loading)
        private set
    init{
        getAllCards()
    }
    fun getAllCards(){
        viewModelScope.launch{
            deckBuilderUiState = DeckBuilderUiState.Loading
            deckBuilderUiState = try{
//                DeckBuilderUiState.Success(repo.getAllCardData())
                DeckBuilderUiState.Success(repo.getAllCardData())
            }catch (e: IOException){
                DeckBuilderUiState.Error
            }catch (e : HttpException){
                DeckBuilderUiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DeckBuilderApplication)
                val cardRepo = application.container.cardRepo
                DeckBuilderViewModel(repo = cardRepo)
            }
        }
    }

}
