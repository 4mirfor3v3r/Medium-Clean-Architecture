package com.acemirr.medium_clean_architecture.data.utils

import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.data.source.local.entity.LocalNewsModel

object Mapper {
    fun toRemoteList(list: List<LocalNewsModel>): List<NewsModel> {
        return list.map { return@map NewsModel(it.title, it.image) }
    }

    fun toLocalList(list: List<NewsModel>?): List<LocalNewsModel> {
        if (list != null) {
            return list.map { return@map LocalNewsModel(null, it.title, it.image) }
        } else return emptyList()
    }
}