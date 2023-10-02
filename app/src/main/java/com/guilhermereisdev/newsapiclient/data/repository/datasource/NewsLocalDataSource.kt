package com.guilhermereisdev.newsapiclient.data.repository.datasource

import com.guilhermereisdev.newsapiclient.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}
