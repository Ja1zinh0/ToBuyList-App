package com.ja1zinh0.appdecompras.data.room.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ja1zinh0.appdecompras.data.room.converters.DateConverter
import com.ja1zinh0.appdecompras.data.room.model.ItemList.ItemList
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [ItemCard::class, Card::class, ItemList::class],
    version = 4,
    exportSchema = false
)
abstract class CardListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun cardDao(): CardDao
    abstract fun itemCardDao(): ItemCardDao

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
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

val MIGRATION_1_2 = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE card_list_new (
                cardID INTEGER PRIMARY KEY NOT NULL,
                title TEXT NOT NULL,
                totalPrice TEXT NOT NULL
            )
        """.trimIndent())
        db.execSQL("""
            CREATE TABLE itemCard_list (
                itemId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                cardId INTEGER NOT NULL, 
                name TEXT NOT NULL,
                value REAL NOT NULL,
                quantity INTEGER NOT NULL
            )
        """.trimIndent())
        db.execSQL("DROP TABLE card_list")
        db.execSQL("ALTER TABLE card_list_new RENAME TO card_list")
    }
}
