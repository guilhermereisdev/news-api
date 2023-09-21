package com.guilhermereisdev.newsapiclient.presentation.di

import com.guilhermereisdev.newsapiclient.data.repository.NewsRepositoryImpl
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}
