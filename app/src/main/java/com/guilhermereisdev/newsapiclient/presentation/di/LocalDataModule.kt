package com.guilhermereisdev.newsapiclient.presentation.di

import com.guilhermereisdev.newsapiclient.data.db.ArticleDAO
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.guilhermereisdev.newsapiclient.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }
}
