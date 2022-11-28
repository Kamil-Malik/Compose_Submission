package com.lelestacia.submissioncompose.di

import android.content.Context
import com.lelestacia.submissioncompose.data.repository.MainRepository
import com.lelestacia.submissioncompose.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainRepository(@ApplicationContext mContext: Context) : MainRepository {
        return MainRepositoryImpl(mContext)
    }
}