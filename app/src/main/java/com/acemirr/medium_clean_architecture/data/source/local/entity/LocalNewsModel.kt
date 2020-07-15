package com.acemirr.medium_clean_architecture.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
data class LocalNewsModel (
    @PrimaryKey(autoGenerate = true)
    val id:Long?,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlToImage") val image: String?
)