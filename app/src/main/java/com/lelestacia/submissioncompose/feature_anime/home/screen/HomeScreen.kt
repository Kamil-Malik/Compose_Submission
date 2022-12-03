package com.lelestacia.submissioncompose.feature_anime.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lelestacia.submissioncompose.feature_anime.home.component.AnimeLazyColumn
import com.lelestacia.submissioncompose.feature_anime.home.component.AnimeSearchBar
import com.lelestacia.submissioncompose.feature_anime.home.viewmodel.HomeViewModel
import com.lelestacia.submissioncompose.ui.theme.Beige

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onClicked: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val data = viewModel.listOfAnime(searchQuery)
        .collectAsState(initial = listOf())
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Beige)
    ) {
        AnimeSearchBar(searchQuery, { newSearchQuery ->
            searchQuery = newSearchQuery
        })
        AnimeLazyColumn(anime = data.value, onClicked = {
            onClicked(it)
        })
    }
}