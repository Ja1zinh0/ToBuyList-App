package com.ja1zinh0.appdecompras.data.room.model.itemCard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "card_list")
data class ItemCard(
    @ColumnInfo(name = "card_id")
    @PrimaryKey
    val cardID: Int,
    val title: String,
    val totalPrice: String,
)

@Entity(tableName = "cards")
data class Card(
    @ColumnInfo(name = "card_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val totalPrice: String,
    @ColumnInfo(name = "listIdFk")
    val listIdFk: Int,
    @ColumnInfo(name = "storeIDFk")
    val storeIDFk: Int,
    val date: Date,
)

@Entity(tableName = "stores")
data class Store(
    @ColumnInfo(name = "store_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "listIdFk")
    val listIdFk: Int,
)
