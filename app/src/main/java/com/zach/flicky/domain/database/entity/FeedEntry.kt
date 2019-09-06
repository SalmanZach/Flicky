package com.zach.flicky.domain.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.zach.flicky.domain.database.FeedConverter
import com.zach.flicky.domain.network.response.Feed


/**
 * Created by Salman Zach on 6/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

@Entity
data class FeedEntry(
    @PrimaryKey(autoGenerate = false)
    var dateAndTime: String = "",
    var tag: String = "",
    @TypeConverters(FeedConverter::class)
    var feeds: List<Feed> = listOf()
)

