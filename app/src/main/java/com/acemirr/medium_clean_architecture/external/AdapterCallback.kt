package com.acemirr.medium_clean_architecture.external

import androidx.recyclerview.widget.DiffUtil
import com.acemirr.medium_clean_architecture.data.model.NewsModel

object AdapterCallback {
    fun mainRvCallback() = object : DiffUtil.ItemCallback<NewsModel>() {
        override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem.title == newItem.title
        }
    }
}