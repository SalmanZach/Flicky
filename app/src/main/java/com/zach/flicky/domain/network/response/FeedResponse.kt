package com.zach.flicky.domain.network.response


import com.google.gson.annotations.SerializedName
import com.zach.flicky.domain.database.entity.Feed


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

data class FeedResponse(
    @SerializedName("description")
    var description: String = "",
    @SerializedName("generator")
    var generator: String = "",
    @SerializedName("items")
    var feeds: List<Feed> = listOf(),
    @SerializedName("link")
    var link: String = "",
    @SerializedName("modified")
    var modified: String = "",
    @SerializedName("title")
    var title: String = ""
)