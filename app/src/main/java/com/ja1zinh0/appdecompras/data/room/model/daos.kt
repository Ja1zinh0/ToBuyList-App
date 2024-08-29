package com.ja1zinh0.appdecompras.data.room.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ja1zinh0.appdecompras.data.room.model.ItemList.ItemList
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard
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
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardList(cardList: ItemCard)

    @Query("SELECT * FROM card_list")
    fun getCards(): Flow<List<ItemCard>>

}

@Dao
interface ItemCardDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItemCard(item: ItemList)

    @Delete
    suspend fun deleteItem(item: ItemList)

    @Query("SELECT * FROM itemCard_list WHERE cardID = :cardId")
    fun getItemsForCard(cardId: Int):Flow<List<ItemList>>
}

data class CardsWithStoreAndList(
    @Embedded(prefix = "card_") val card: Card,
    @Embedded(prefix = "cardList_") val cardList: ItemCard,
    @Embedded(prefix = "itemCard_") val itemCardList: ItemList,
)
