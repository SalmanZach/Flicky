package com.zach.flicky.domain.repository

import androidx.lifecycle.LiveData
import com.zach.flicky.domain.database.entity.Feed



/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
interface FlickerRepository {

    suspend fun loadFeeds(tag:String)

    suspend fun getFeedByTag(tag:String): LiveData<List<Feed>>

}