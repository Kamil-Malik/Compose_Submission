package com.lelestacia.submissioncompose.feature_anime.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    repository: MainRepository
) : ViewModel() {

    val favoriteAnime: Flow<List<AnimeModel>> = repository.getFavoriteAnimeList()
}