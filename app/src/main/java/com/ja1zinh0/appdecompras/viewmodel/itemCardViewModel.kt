package com.ja1zinh0.appdecompras.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ja1zinh0.appdecompras.data.room.model.CardListDatabase
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val database: CardListDatabase
) : ViewModel() {
    private val _cardItems = MutableStateFlow<List<ItemCard>>(emptyList())
    val cardItems: StateFlow<List<ItemCard>> get() = _cardItems

    init {
        viewModelScope.launch {
            database.listDao().getCards().collect { cards ->
                _cardItems.value = cards
            }
        }
    }

    fun addItem(card: ItemCard) {
        Log.d("CardListViewModel", "Adding ItemCard: $card")
        viewModelScope.launch {
            database.listDao().insertCardList(card)
            Log.d("CardListViewModel", "ItemCard added successfully: $card")

            // Debug: Verificar o estado atual da tabela após a inserção
            database.listDao().getCards().collect { items ->
                Log.d("CardListViewModel", "Current items in card_list: $items")
            }
        }
    }

    fun removeItem(cardID: Int) {
        viewModelScope.launch {
            val cardToDelete = _cardItems.value.find { it.cardID == cardID }
            cardToDelete?.let {
                database.cardDao().delete(it)
            }
        }
    }

    fun generateUniqueId(): Int {
        return (_cardItems.value.maxOfOrNull { it.cardID } ?: 0) + 1
    }
}