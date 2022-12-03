package com.lelestacia.submissioncompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lelestacia.submissioncompose.data.model.AnimeModel

@Database(
    entities = [AnimeModel::class],
    version = 1
)
abstract class AnimeDB : RoomDatabase(){

    abstract fun animeDao() : AnimeDao
}