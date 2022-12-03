package com.lelestacia.submissioncompose.feature_anime.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lelestacia.submissioncompose.feature_anime.detail.component.DetailAnimeDesc
import com.lelestacia.submissioncompose.feature_anime.detail.component.DetailAnimeHeader
import com.lelestacia.submissioncompose.feature_anime.detail.viewmodel.AnimeResult
import com.lelestacia.submissioncompose.feature_anime.detail.viewmodel.DetailViewModel
import com.lelestacia.submissioncompose.ui.theme.Beige
import com.lelestacia.submissioncompose.ui.theme.Navy

@Composable
fun DetailScreen(
    title: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    viewModel.getAnimeByTitle(title)
    when (val animeResult = viewModel.animeModel.value) {
        is AnimeResult.Exist -> {
            with(animeResult.data) {
                var favorite by remember { mutableStateOf(this.isFavorite) }
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Beige),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        DetailAnimeHeader(
                            title = title,
                            episode = episode,
                            status = status,
                            score = score,
                            coverUrl = cover_url,
                            rank = rank,
                            premiere = premiered
                        )
                        DetailAnimeDesc(
                            descriptionOne = first_description,
                            descriptionTwo = second_description
                        )
                    }
                    FloatingActionButton(
                        onClick = {
                            favorite = !favorite
                            viewModel.addToFavorite(animeResult.data.apply {
                                isFavorite = !isFavorite
                            })
                        },
                        modifier = modifier
                            .align(Alignment.End)
                            .padding(24.dp),
                        backgroundColor = Navy
                    ) {
                        Icon(
                            imageVector =
                            if (favorite) {
                                Icons.Filled.Favorite
                            } else {
                                Icons.Outlined.FavoriteBorder
                            },
                            contentDescription = "Fab Favorite",
                            tint = Color.White
                        )
                    }
                }
            }
        }
        AnimeResult.None -> Unit
    }
}