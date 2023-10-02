package com.guilhermereisdev.newsapiclient.data.repository.datasourceimpl

import com.guilhermereisdev.newsapiclient.data.db.ArticleDAO
import com.guilhermereisdev.newsapiclient.data.model.Article
import com.guilhermereisdev.newsapiclient.data.repository.datasource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO,
) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }
}
