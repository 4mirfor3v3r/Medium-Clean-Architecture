package com.acemirr.medium_clean_architecture.domain.repository

import com.acemirr.medium_clean_architecture.data.model.NewsModel

interface ListRepository {
    suspend fun getPagedNews(page:Int,pageSize:Int):List<NewsModel>?
}