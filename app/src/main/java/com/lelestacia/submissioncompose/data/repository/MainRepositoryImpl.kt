package com.lelestacia.submissioncompose.data.repository

import android.content.Context
import com.lelestacia.submissioncompose.R
import com.lelestacia.submissioncompose.data.database.AnimeDao
import com.lelestacia.submissioncompose.data.model.AnimeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mContext: Context,
    private val animeDao: AnimeDao
) : MainRepository {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            populateDb()
        }
    }

    override fun getAnimeList(): Flow<List<AnimeModel>>  {
       return animeDao.getAnimeList()
    }

    override fun getAnimeListByTitle(title: String): Flow<List<AnimeModel>> {
        return animeDao.getListOfAnimeByTitle("%$title%")
    }

    override fun getFavoriteAnimeList(): Flow<List<AnimeModel>> {
        return animeDao.getFavoriteAnimeLIst()
    }

    override fun getAnimeByTitle(title: String): AnimeModel {
        return animeDao.getAnimeByTitle(title)
    }

    override suspend fun populateDb() {
        animeDao.insertListOfAnime(setDummy())
    }

    override suspend fun addOrRemoveFromFavorite(anime: AnimeModel) {
        animeDao.addFavorite(anime)
    }

    private fun setDummy() : List<AnimeModel> {
        val title = mContext.resources.getStringArray(R.array.title)
        val score = mContext.resources.getStringArray(R.array.score)
            .map { it.toDouble() }
        val rank = mContext.resources.getStringArray(R.array.rank)
            .map { it.toInt() }
        val firstDescription = mContext.resources.getStringArray(R.array.first_description)
        val secondDescription = mContext.resources.getStringArray(R.array.second_description)
        val coverUrl = mContext.resources.getStringArray(R.array.cover_url)
        val type = mContext.resources.getStringArray(R.array.type)
        val episode = mContext.resources.getStringArray(R.array.episode)
            .map { it.toInt() }
        val status = mContext.resources.getStringArray(R.array.status)
        val premiered = mContext.resources.getStringArray(R.array.premiered)

        val animeList = arrayListOf<AnimeModel>()

        for (i in title.indices) {
            animeList.add(
                AnimeModel(
                    title = title[i],
                    score = score[i],
                    rank = rank[i],
                    first_description = firstDescription[i],
                    second_description = secondDescription[i],
                    cover_url = coverUrl[i],
                    type = type[i],
                    episode = episode[i],
                    status = status[i],
                    premiered = premiered[i]
                )
            )
        }

        return animeList
    }
}
