package com.lelestacia.submissioncompose.feature_anime.detail.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _animeModel: MutableState<AnimeResult> = mutableStateOf(
        AnimeResult.None
    )
    val animeModel: State<AnimeResult> get() = _animeModel

    fun getAnimeByTitle(title: String) {
       viewModelScope.launch(Dispatchers.IO) {
          _animeModel.value = AnimeResult.Exist(repository.getAnimeByTitle(title))
       }
    }

    fun addToFavorite(animeModel: AnimeModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOrRemoveFromFavorite(animeModel)
        }
    }
}

sealed class AnimeResult() {
    object None : AnimeResult()
    data class Exist(val data: AnimeModel) : AnimeResult()
}