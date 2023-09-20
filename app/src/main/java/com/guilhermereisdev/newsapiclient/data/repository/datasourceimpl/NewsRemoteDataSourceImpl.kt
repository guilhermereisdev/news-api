package com.guilhermereisdev.newsapiclient.data.repository.datasourceimpl

import com.guilhermereisdev.newsapiclient.data.api.NewsAPIService
import com.guilhermereisdev.newsapiclient.data.model.APIResponse
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}
