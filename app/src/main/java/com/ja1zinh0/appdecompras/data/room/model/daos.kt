package com.ja1zinh0.appdecompras.data.room.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Store
import com.ja1zinh0.appdecompras.viewmodel.CardListViewModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Insert()
    suspend fun insert(card: ItemCard)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(card: ItemCard)

    @Delete
    suspend fun delete(card: ItemCard)

    @Query("SELECT * FROM cards")
    fun getAllCards(): Flow<List<Card>>

}

@Dao
interface StoreDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(store: Store)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(store: Store)

    @Delete
    suspend fun delete(store: Store)

    @Query("SELECT * FROM stores")
    fun getAllStores(): Flow<List<Store>>

}

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardList(cardList: ItemCard)

    @Query("SELECT * FROM card_list")
    fun getCards(): Flow<List<ItemCard>>

}

data class CardsWithStoreAndList(
    @Embedded(prefix = "card_") val card: Card,
    @Embedded(prefix = "cardList_") val cardList: ItemCard,
    @Embedded(prefix = "store_") val store: Store
)
