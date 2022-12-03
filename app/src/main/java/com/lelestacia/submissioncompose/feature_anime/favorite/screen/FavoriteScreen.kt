package com.lelestacia.submissioncompose.feature_anime.favorite.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lelestacia.submissioncompose.feature_anime.favorite.viewmodel.FavoriteViewModel
import com.lelestacia.submissioncompose.feature_anime.home.component.AnimeLazyColumn
import com.lelestacia.submissioncompose.ui.theme.Beige

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    onClicked: (String) -> Unit
) {
    val data = viewModel.favoriteAnime.collectAsState(initial = listOf())
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Beige)
    ) {
       AnimeLazyColumn(anime = data.value, onClicked ={
            onClicked(it)
       })
    }
}