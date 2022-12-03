package com.lelestacia.submissioncompose.feature_anime.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lelestacia.submissioncompose.data.model.AnimeModel

@Composable
fun AnimeLazyColumn(
    anime: List<AnimeModel>,
    onClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(anime) { anime ->
            AnimeRow(
                title = anime.title,
                episode = anime.episode,
                status = anime.status,
                score = anime.score,
                coverUrl = anime.cover_url,
                onClicked = {
                    onClicked(it)
                }
            )
        }
    }
}