package com.lelestacia.submissioncompose.data.repository

import android.content.Context
import com.lelestacia.submissioncompose.R
import com.lelestacia.submissioncompose.data.model.AnimeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mContext: Context
) : MainRepository {

    private val animeData = MutableStateFlow(setDummy())

    override fun getData(): StateFlow<List<AnimeModel>> {
        return animeData.asStateFlow()
    }

    private fun setDummy() : List<AnimeModel> {
        val title = mContext.resources.getStringArray(R.array.title)
        val score = mContext.resources.getStringArray(R.array.score)
            .map { it.toDouble() }
        val rank = mContext.resources.getStringArray(R.array.rank)
            .map { it.toInt() }
//        val firstDescription = mContext.resources.getStringArray(R.array.first_description)
//        val secondDescription = mContext.resources.getStringArray(R.array.second_description)
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
                    first_description = "",
                    second_description = "",
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