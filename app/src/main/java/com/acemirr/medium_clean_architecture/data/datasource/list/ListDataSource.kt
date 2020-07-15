package com.acemirr.medium_clean_architecture.data.datasource.list

import com.acemirr.medium_clean_architecture.data.model.NewsListsModel
import com.acemirr.medium_clean_architecture.data.source.local.entity.LocalNewsModel
import com.acemirr.medium_clean_architecture.data.utils.DataState

interface ListDataSource {
    interface Remote {
        suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>?
    }

    interface Local : Remote {
        suspend fun savePagedList(list: List<LocalNewsModel>)
    }
}