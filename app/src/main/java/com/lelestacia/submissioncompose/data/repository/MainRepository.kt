package com.lelestacia.submissioncompose.data.repository

import com.lelestacia.submissioncompose.data.model.AnimeModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getAnimeList(): Flow<List<AnimeModel>>

    fun getAnimeListByTitle(title: String): Flow<List<AnimeModel>>

    fun getFavoriteAnimeList(): Flow<List<AnimeModel>>

    fun getAnimeByTitle(title: String): AnimeModel

    suspend fun addOrRemoveFromFavorite(anime: AnimeModel)

    suspend fun populateDb()
}