package com.ja1zinh0.appdecompras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ja1zinh0.appdecompras.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel@Inject constructor(
    private val repository: CardRepository
) : ViewModel() {

    val cardItems: StateFlow<List<ItemCard>> = repository.getCardItems()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addItem(item: ItemCard) {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    fun removeItem(item: ItemCard) {
        viewModelScope.launch {
            repository.removeItem(item)
        }
    }

    fun updateItem(item: ItemCard) {
        viewModelScope.launch {
            repository.updateItem(item)
        }
    }
}