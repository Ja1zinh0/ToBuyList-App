package com.ja1zinh0.appdecompras.data.room.model.ItemList

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemCard_list")
data class ItemList(
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0,
    val cardId: Int,
    val name: String,
    val value: Float,
    val quantity: Int
)
