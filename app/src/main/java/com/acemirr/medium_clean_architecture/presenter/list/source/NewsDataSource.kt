package com.acemirr.medium_clean_architecture.presenter.list.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.domain.usecase.ListUseCase
import com.acemirr.medium_clean_architecture.external.LoadingState
import kotlinx.coroutines.*

class NewsDataSource(private val scope: CoroutineScope, private val useCase: ListUseCase):PageKeyedDataSource<Int,NewsModel>() {

    var state:MutableLiveData<LoadingState> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, NewsModel>) {
        scope.launch(Dispatchers.IO) {
//            delay(1000)
            state.postValue(LoadingState.LOADING)
            val res = async { useCase.getPagedNews(1,params.requestedLoadSize) }
                val list = res.await()?.toMutableList()
                if (list != null) {
                    callback.onResult(list, null, 2)
                }
                state.postValue(LoadingState.DONE)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {
        scope.launch(Dispatchers.IO) {
//            delay(1000)
            state.postValue(LoadingState.LOADING)
            val res = async { useCase.getPagedNews(params.key,params.requestedLoadSize) }
                val list = res.await()?.toMutableList()
                if (list != null) {
                    callback.onResult(list,  params.key+1)
                }
                state.postValue(LoadingState.DONE)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {
    }
}