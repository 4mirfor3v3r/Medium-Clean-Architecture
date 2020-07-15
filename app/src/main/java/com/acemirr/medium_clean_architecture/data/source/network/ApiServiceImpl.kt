package com.acemirr.medium_clean_architecture.data.source.network

import com.acemirr.medium_clean_architecture.data.model.NewsListsModel
import retrofit2.Response

class ApiServiceImpl:ApiService {
    override suspend fun getPagedNews(page: Int, pageSize: Int): Response<NewsListsModel> {
        return NetworkConfig.api().getPagedNews(page, pageSize)
    }
}