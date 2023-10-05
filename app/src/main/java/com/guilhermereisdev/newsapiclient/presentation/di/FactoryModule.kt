package com.guilhermereisdev.newsapiclient.presentation.di

import android.app.Application
import com.guilhermereisdev.newsapiclient.domain.usecase.DeleteSavedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetSavedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.SaveNewsUseCase
import com.guilhermereisdev.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase,
        )
    }
}
