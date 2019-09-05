package com.zach.flicky.domain.network.response


import com.google.gson.annotations.SerializedName


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
data class Media(
    @SerializedName("m")
    var imageUrl: String = ""
)