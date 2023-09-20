package com.guilhermereisdev.newsapiclient.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequests_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines(page = 1).body()
            val request = server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path)
                .isEqualTo("/v2/top-headlines?country=pt&page=1&apiKey=a1b32489fc8c4554a4702c666f60061f")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines(page = 1).body()
            val articlesList = responseBody!!.articles
            Truth.assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines(page = 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            Truth.assertThat(article.author).isEqualTo("Versa")
            Truth.assertThat(article.url)
                .isEqualTo("https://news.google.com/rss/articles/CBMihwFodHRwczovL3ZlcnNhLmlvbC5wdC9uZWNlc3NhaXJlL2VtYWdyZWNlci9hZmluYWwtYmFzdGEtYWx0ZXJhci1hLW9yZGVtLWRvcy1hbGltZW50b3MtcGFyYS1wZXJkZXItcGVzby8yMDIzMDkxOS82NTA4MTYxMGQzNGU2NWFmYTJmNTcxYznSAQA?oc=5")
            Truth.assertThat(article.publishedAt).isEqualTo("2023-09-19T00:22:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
