package com.lelestacia.submissioncompose.feature_anime.home.viewmodel

import androidx.lifecycle.ViewModel
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun listOfAnime(title: String): Flow<List<AnimeModel>> {
        return repository.getAnimeListByTitle(title)
    }
}