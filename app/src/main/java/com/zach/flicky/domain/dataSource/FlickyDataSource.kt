package com.zach.flicky.domain.dataSource

import androidx.lifecycle.LiveData
import com.zach.flicky.domain.database.entity.Feed


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
interface FlickyDataSource {

    val downloadedFeeds: LiveData<List<Feed>>

    suspend fun fetchFeedsData(tag:String)


}