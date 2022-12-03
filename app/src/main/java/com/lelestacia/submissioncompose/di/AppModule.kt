package com.lelestacia.submissioncompose.di

import android.content.Context
import androidx.room.Room
import com.lelestacia.submissioncompose.data.database.AnimeDB
import com.lelestacia.submissioncompose.data.database.AnimeDao
import com.lelestacia.submissioncompose.data.repository.MainRepository
import com.lelestacia.submissioncompose.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAnimeDB(@ApplicationContext mContext: Context) =
        Room.databaseBuilder(mContext, AnimeDB::class.java, "anime_db").build()

    @Provides
    @Singleton
    fun provideAnimeDao(animeDB: AnimeDB) = animeDB.animeDao()

    @Provides
    @Singleton
    fun provideMainRepository(@ApplicationContext mContext: Context, dao: AnimeDao) : MainRepository {
        return MainRepositoryImpl(mContext, dao)
    }
}