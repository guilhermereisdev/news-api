package com.guilhermereisdev.newsapiclient.domain.usecase

import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}