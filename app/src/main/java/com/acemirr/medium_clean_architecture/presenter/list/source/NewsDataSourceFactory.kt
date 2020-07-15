package com.acemirr.medium_clean_architecture.presenter.list.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.domain.usecase.ListUseCase
import kotlinx.coroutines.CoroutineScope

class NewsDataSourceFactory(private val scope: CoroutineScope, private val useCase: ListUseCase) :
    DataSource.Factory<Int, NewsModel>() {

    val newsDataSourceLiveData: MutableLiveData<NewsDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, NewsModel> {
        val newsDataSource = NewsDataSource(scope, useCase)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}