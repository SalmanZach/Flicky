package com.zach.flicky.domain.glide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.scorebell.utility.glide.GlideApp
import com.zach.flicky.R



/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
object ImageLoader {

    @JvmStatic
    @BindingAdapter("loadMediumImage")
    fun loadMediumImage(imageView: ImageView, url: String) {

        GlideApp.with(imageView.context.applicationContext)
            .load(url.replace("_m", "_e"))
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .placeholder(R.drawable.ic_watermark)
            .error(R.drawable.ic_watermark)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("loadLargeImage")
    fun loadLargeImage(imageView: ImageView, url: String) {

        GlideApp.with(imageView.context.applicationContext)
            .load(url.replace("_m", "_b"))
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .placeholder(R.drawable.ic_watermark)
            .error(R.drawable.ic_watermark)
            .into(imageView)
    }

}