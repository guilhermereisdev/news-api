package com.guilhermereisdev.newsapiclient.data.repository

import com.guilhermereisdev.newsapiclient.data.model.APIResponse
import com.guilhermereisdev.newsapiclient.data.model.Article
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.guilhermereisdev.newsapiclient.data.util.Resource
import com.guilhermereisdev.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
) : NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int,
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedTopHeadlines(country, searchQuery, page)
        )
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}
