package com.acemirr.medium_clean_architecture.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class NewsListsModel(
    @SerializedName("articles") var newsModel: List<NewsModel>
):Parcelable