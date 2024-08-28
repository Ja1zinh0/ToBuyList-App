package com.ja1zinh0.appdecompras.repository

import com.ja1zinh0.appdecompras.data.room.model.CardDao
import com.ja1zinh0.appdecompras.data.room.model.ListDao
import com.ja1zinh0.appdecompras.data.room.model.StoreDao
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Store

class Repository(
    private val listDao: ListDao,
    private val storeDao: StoreDao,
    private val cardDao: CardDao,
){
    val store = storeDao.getAllStores()

    suspend fun insertList(cardList: ItemCard){
        listDao.insertCardList(cardList)
    }

    suspend fun insertStore(store: Store){
        storeDao.insert(store)
    }

    suspend fun insertCard(card: ItemCard){
        cardDao.insert(card)
    }

    suspend fun deleteCard(card: ItemCard){
        cardDao.delete(card)
    }

    suspend fun updateCard(card: ItemCard){
        cardDao.update(card)
    }
}