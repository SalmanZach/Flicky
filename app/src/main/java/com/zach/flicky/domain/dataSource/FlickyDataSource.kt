package com.zach.flicky.domain.dataSource

import androidx.lifecycle.LiveData
import com.zach.flicky.domain.database.entity.FeedEntry


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
interface FlickyDataSource {

    val downloadedFeeds: LiveData<FeedEntry>
    suspend fun fetchFeedsData(tag:String)


}