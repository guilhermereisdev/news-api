package com.guilhermereisdev.newsapiclient.domain.usecase

import com.guilhermereisdev.newsapiclient.data.model.APIResponse
import com.guilhermereisdev.newsapiclient.data.util.Resource
import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}
