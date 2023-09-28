package com.guilhermereisdev.newsapiclient.domain.usecase

import com.guilhermereisdev.newsapiclient.data.model.APIResponse
import com.guilhermereisdev.newsapiclient.data.util.Resource
import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}
