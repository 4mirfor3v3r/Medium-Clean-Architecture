package com.acemirr.medium_clean_architecture.domain.usecase

import android.util.Log
import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.domain.repository.ListRepository
import javax.inject.Inject

class ListUseCase @Inject constructor(private val repository: ListRepository) {
    suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>? {
        Log.e("USECASE", "GETTING DATA FROM REPO")
        return repository.getPagedNews(page, pageSize)
    }
}