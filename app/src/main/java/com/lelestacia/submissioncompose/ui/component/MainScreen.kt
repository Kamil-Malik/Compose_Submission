package com.lelestacia.submissioncompose.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lelestacia.submissioncompose.data.model.AnimeModel

@Composable
fun MainScreen(
    animeList: List<AnimeModel>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(animeList) { it ->
            AnimeRow(
                title = it.title,
                episode = it.episode,
                status = it.status,
                score = it.score,
                coverUrl = it.cover_url,
                onClicked = { onClick(it) }
            )
        }
    }
}