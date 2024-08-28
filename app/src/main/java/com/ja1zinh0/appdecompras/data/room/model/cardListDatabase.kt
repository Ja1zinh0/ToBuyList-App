package com.ja1zinh0.appdecompras.data.room.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ja1zinh0.appdecompras.data.room.converters.DateConverter
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Store
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [ItemCard::class, Card::class, Store::class],
    version = 1,
    exportSchema = false
)
abstract class CardListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun cardDao(): CardDao
    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var INSTANCE: CardListDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): CardListDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardListDatabase::class.java,
                    "card_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
