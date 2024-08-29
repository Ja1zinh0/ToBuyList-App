package com.ja1zinh0.appdecompras.repository

import com.ja1zinh0.appdecompras.data.room.model.CardDao
import com.ja1zinh0.appdecompras.data.room.model.ListDao
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard

class Repository(
    private val listDao: ListDao,
    private val cardDao: CardDao,
){

    suspend fun insertList(cardList: ItemCard){
        listDao.insertCardList(cardList)
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