package com.zach.flicky.domain.database.doa

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zach.flicky.domain.database.entity.Feed

/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
@Dao
interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeeds(feed: List<Feed>): List<Long>

    @Query("SELECT * FROM Feed WHERE tag =:tag")
    fun getFeedByTag(tag:String): LiveData<List<Feed>>

    @Query("DELETE  FROM Feed WHERE tag =:tag")
    fun deleteAll(tag: String)
}