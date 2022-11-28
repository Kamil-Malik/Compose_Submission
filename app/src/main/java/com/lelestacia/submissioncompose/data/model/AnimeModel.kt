package com.lelestacia.submissioncompose.data.model

data class AnimeModel(

    val title: String,

    val score: Double,

    val rank: Int,

    val first_description: String,

    val second_description: String?,

    val cover_url: String,

    val type: String,

    val episode: Int,

    val status: String,

    val premiered: String,

    var isFavorite: Boolean = false
)