package com.acemirr.medium_clean_architecture.presenter.list.adapter

import com.acemirr.medium_clean_architecture.data.model.NewsModel

interface MainRvAction {
    fun onItemClick(data:NewsModel)
}