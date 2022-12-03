package com.lelestacia.submissioncompose.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "anime_table")
data class AnimeModel(

    @PrimaryKey
    val title: String,

    val score: Double,

    val rank: Int,

    val first_description: String,

    val second_description: String,

    val cover_url: String,

    val type: String,

    val episode: Int,

    val status: String,

    val premiered: String,

    var isFavorite: Boolean = false
): Parcelable