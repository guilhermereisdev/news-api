package com.guilhermereisdev.newsapiclient.domain.usecase

import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}