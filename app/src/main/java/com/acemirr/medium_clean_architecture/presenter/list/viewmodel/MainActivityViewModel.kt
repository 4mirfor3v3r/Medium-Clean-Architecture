package com.acemirr.medium_clean_architecture.presenter.list.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.domain.usecase.ListUseCase
import com.acemirr.medium_clean_architecture.external.LoadingState
import com.acemirr.medium_clean_architecture.presenter.list.source.NewsDataSource
import com.acemirr.medium_clean_architecture.presenter.list.source.NewsDataSourceFactory
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val useCase: ListUseCase) : ViewModel() {

    var dataSourceFactory: NewsDataSourceFactory? = null
    var list: LiveData<PagedList<NewsModel>>? = null

    fun startPaging() {
        Log.e("VIEWMODEL", "GETTING FROM USECASE")
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()
        dataSourceFactory = NewsDataSourceFactory(viewModelScope, useCase)

        if (dataSourceFactory != null)
            list = LivePagedListBuilder(dataSourceFactory!!, config).build()
    }

    fun getLoadingState(): LiveData<LoadingState>? {
        return if (dataSourceFactory != null)
            Transformations.switchMap(
                dataSourceFactory!!.newsDataSourceLiveData,
                NewsDataSource::state
            )
        else
            null
    }
}