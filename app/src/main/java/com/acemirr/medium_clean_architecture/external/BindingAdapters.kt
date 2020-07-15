package com.acemirr.medium_clean_architecture.external

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.acemirr.medium_clean_architecture.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

object BindingAdapters {
    private val picasso: Picasso
        get() = Picasso.get()

    private fun ImageView.load(path:String?, request:(RequestCreator) ->RequestCreator){
        if (!path.isNullOrEmpty()) {
            request(picasso.load(path))
                .priority(Picasso.Priority.HIGH)
                .into(this)
        }
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url:String?){
        if (url!=null){
            view.load(url){requestCreator ->
                requestCreator.fit().centerCrop()
            }
        }
    }
}