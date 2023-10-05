package com.guilhermereisdev.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guilhermereisdev.newsapiclient.domain.usecase.DeleteSavedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetSavedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.guilhermereisdev.newsapiclient.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase,
        ) as T
    }
}
