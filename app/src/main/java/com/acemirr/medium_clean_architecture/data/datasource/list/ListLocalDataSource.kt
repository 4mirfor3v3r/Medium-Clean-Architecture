package com.acemirr.medium_clean_architecture.data.datasource.list

import com.acemirr.medium_clean_architecture.data.model.NewsListsModel
import com.acemirr.medium_clean_architecture.data.source.local.dao.ListDao
import com.acemirr.medium_clean_architecture.data.source.local.entity.LocalNewsModel
import com.acemirr.medium_clean_architecture.data.utils.DataNotAvailableException
import com.acemirr.medium_clean_architecture.data.utils.DataState
import com.acemirr.medium_clean_architecture.data.utils.Mapper
import javax.inject.Inject

class ListLocalDataSource @Inject constructor(private val dao: ListDao) : ListDataSource.Local {
    override suspend fun savePagedList(list: List<LocalNewsModel>) {
        return dao.insertAllNews(list)
    }

    override suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>? {
        val maxPages = (dao.getPagingCount() ?: 0) / pageSize
        return if (page < maxPages) {
            val res = dao.getPagedNews(page, pageSize)
            return if (res.isNotEmpty()){
                DataState.Success(NewsListsModel(Mapper.toRemoteList(res)))
            } else
                DataState.Error(DataNotAvailableException())
        }
        else DataState.Error(DataNotAvailableException())
    }
}

//val res = runBlocking {
//    val maxPages = (dao.getPagingCount() ?: 0) / pageSize
//    return@runBlocking if (page < maxPages) {
//        val res = withContext(dispather.coroutineContext)
//        { dao.getPagedNews(page, pageSize) }
//        return@runBlocking if (res.isNotEmpty()){
//            DataState.Success(NewsListsModel(Mapper.toRemoteList(res)))
//        } else
//            DataState.Error(NetworkErrorException("Data Not Available"))
//    }
//    else DataState.Error(NetworkErrorException("Data Not Available"))
//}
//return res