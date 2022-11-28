package com.lelestacia.submissioncompose

import androidx.lifecycle.ViewModel
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    fun getData(): StateFlow<List<AnimeModel>> {
        return repository.getData()
    }
}