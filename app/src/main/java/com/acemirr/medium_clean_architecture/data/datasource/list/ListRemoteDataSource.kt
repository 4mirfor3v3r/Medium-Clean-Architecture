package com.acemirr.medium_clean_architecture.data.datasource.list

import com.acemirr.medium_clean_architecture.data.model.NewsListsModel
import com.acemirr.medium_clean_architecture.data.source.network.ApiServiceImpl
import com.acemirr.medium_clean_architecture.data.utils.DataNotAvailableException
import com.acemirr.medium_clean_architecture.data.utils.DataState
import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(private val apiService: ApiServiceImpl):ListDataSource.Remote {
    override suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>? {
        val res = apiService.getPagedNews(page, pageSize)
        return if (res.isSuccessful){
            DataState.Success(res.body())
        } else
            DataState.Error(DataNotAvailableException())
    }
}