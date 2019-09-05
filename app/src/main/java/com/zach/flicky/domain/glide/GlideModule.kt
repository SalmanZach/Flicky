package com.scorebell.utility.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule



/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
@GlideModule
class GlideModule : AppGlideModule() {
    private val CASHE = (50 * 1024 * 1024).toLong()
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDiskCache(DiskLruCacheFactory(Glide.getPhotoCacheDir(context)!!.absolutePath, CASHE))
        builder.setMemoryCache(LruResourceCache(CASHE))
    }
}