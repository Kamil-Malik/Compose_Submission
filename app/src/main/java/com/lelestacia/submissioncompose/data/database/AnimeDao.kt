package com.lelestacia.submissioncompose.data.database

import androidx.room.*
import com.lelestacia.submissioncompose.data.model.AnimeModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListOfAnime(anime: List<AnimeModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(anime: AnimeModel)

    @Query("SELECT * FROM anime_table ORDER BY title ASC")
    fun getAnimeList(): Flow<List<AnimeModel>>

    @Query("SELECT * FROM anime_table WHERE isFavorite = 1 ORDER BY title ASC")
    fun getFavoriteAnimeLIst(): Flow<List<AnimeModel>>

    @Query("SELECT * FROM anime_table WHERE title LIke :title ORDER BY title ASC")
    fun getListOfAnimeByTitle(title: String) : Flow<List<AnimeModel>>

    @Query("SELECT * FROM anime_table WHERE title =:title")
    fun getAnimeByTitle(title: String): AnimeModel

    @Update
    suspend fun updateAnimeModel(anime: AnimeModel)
}