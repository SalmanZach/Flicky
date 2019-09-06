package com.zach.flicky.domain.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.zach.flicky.domain.network.response.Feed
import com.zach.flicky.utility.fromJson
import com.zach.flicky.utility.json


class FeedConverter {


    @TypeConverter
    fun converToString(list: List<Feed>?): String {
        list ?: return ""
        return list.json()
    }

    @TypeConverter
    fun convertToFeeds(value: String?): List<Feed> {
        if (value.isNullOrEmpty()) {
            return arrayListOf()
        }
        return Gson().fromJson<ArrayList<Feed>>(value)
    }


}
