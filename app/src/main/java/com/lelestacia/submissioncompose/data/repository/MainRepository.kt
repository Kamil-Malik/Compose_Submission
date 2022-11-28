package com.lelestacia.submissioncompose.data.repository

import com.lelestacia.submissioncompose.data.model.AnimeModel
import kotlinx.coroutines.flow.StateFlow

interface MainRepository {

    fun getData(): StateFlow<List<AnimeModel>>
}