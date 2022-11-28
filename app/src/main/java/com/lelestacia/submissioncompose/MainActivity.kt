package com.lelestacia.submissioncompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.ui.component.MainScreen
import com.lelestacia.submissioncompose.ui.theme.SubmissionComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubmissionComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val animeList: List<AnimeModel> = setDummy()
                    MainScreen(animeList = animeList, onClick = {
                        startActivity(Intent(this, DetailActivity::class.java)
                            .putExtra("ANIME", it))
                    })
                }
            }
        }
    }

    private fun setDummy(): List<AnimeModel> {
        val title = this.resources.getStringArray(R.array.title)
        val score = this.resources.getStringArray(R.array.score).map { it.toDouble() }
        val rank = this.resources.getStringArray(R.array.rank).map { it.toInt() }
//        val firstDescription = mContext.resources.getStringArray(R.array.first_description)
//        val secondDescription = mContext.resources.getStringArray(R.array.second_description)
        val coverUrl = this.resources.getStringArray(R.array.cover_url)
        val type = this.resources.getStringArray(R.array.type)
        val episode = this.resources.getStringArray(R.array.episode).map { it.toInt() }
        val status = this.resources.getStringArray(R.array.status)
        val premiered = this.resources.getStringArray(R.array.premiered)

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

        return animeList.sortedBy { it.title }
    }
}