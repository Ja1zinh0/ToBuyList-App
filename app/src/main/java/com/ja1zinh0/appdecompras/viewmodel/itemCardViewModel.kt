package com.ja1zinh0.appdecompras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ja1zinh0.appdecompras.data.room.model.CardListDatabase
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val database: CardListDatabase
) : ViewModel() {
    val cardItems: Flow<List<ItemCard>> = database.listDao().getCards()

    fun addItem(card: ItemCard) {
        viewModelScope.launch {
            database.listDao().insertCardList(card)
        }
    }

    fun removeItem(card: ItemCard) {
        viewModelScope.launch {
            database.cardDao().delete(card)
        }
    }
}
