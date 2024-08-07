package com.ja1zinh0.appdecompras.repository

import com.ja1zinh0.appdecompras.model.itemCard.ItemCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CardRepository @Inject constructor() {

    private val cardItems = MutableStateFlow<List<ItemCard>>(emptyList())

    fun getCardItems(): Flow<List<ItemCard>> = cardItems

    fun addItem(item: ItemCard) {
        cardItems.value += item
    }

    fun removeItem(item: ItemCard) {
        cardItems.value -= item
    }

    fun updateItem(item: ItemCard) {
        val updatedList = cardItems.value.map {
            if (it.cardID == item.cardID) item else it
        }
        cardItems.value = updatedList
    }
}
