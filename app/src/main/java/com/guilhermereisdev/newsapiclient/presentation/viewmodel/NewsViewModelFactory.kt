package com.guilhermereisdev.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guilhermereisdev.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
        ) as T
    }
}
