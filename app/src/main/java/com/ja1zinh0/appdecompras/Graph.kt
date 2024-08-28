package com.ja1zinh0.appdecompras

import android.content.Context
import com.ja1zinh0.appdecompras.data.room.model.CardListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CardListDatabase {
        return CardListDatabase.getDatabase(context)
    }

    @Provides
    fun provideListDao(database: CardListDatabase) = database.listDao()

    @Provides
    fun provideCardDao(database: CardListDatabase) = database.cardDao()

    @Provides
    fun provideStoreDao(database: CardListDatabase) = database.storeDao()
}
