package com.ja1zinh0.appdecompras.data.room.model.itemCard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ja1zinh0.appdecompras.data.room.model.ItemList.ItemList
import java.util.Date

@Entity(tableName = "card_list")
data class ItemCard(
    @PrimaryKey(autoGenerate = true)
    val cardID: Int = 0,
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
