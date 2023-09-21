package com.guilhermereisdev.newsapiclient.presentation.di

import com.guilhermereisdev.newsapiclient.data.api.NewsAPIService
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.guilhermereisdev.newsapiclient.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}
