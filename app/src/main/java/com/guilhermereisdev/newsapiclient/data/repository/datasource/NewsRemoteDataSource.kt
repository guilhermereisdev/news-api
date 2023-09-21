package com.guilhermereisdev.newsapiclient.data.repository.datasource

import com.guilhermereisdev.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(): Response<APIResponse>
}