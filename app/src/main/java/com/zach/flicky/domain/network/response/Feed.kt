package com.zach.flicky.domain.network.response


import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import com.zach.flicky.ui.activity.DATE
import com.zach.flicky.ui.activity.DetailActivity
import com.zach.flicky.ui.activity.IMAGE
import com.zach.flicky.ui.activity.TITLE
import com.zach.flicky.utility.Utility


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

data class Feed(
    @SerializedName("date_taken")
    var dateTaken: String = "",
    @SerializedName("media")
    @Embedded(prefix = "media_")
    var media: Media = Media(),
    @SerializedName("title")
    var title: String = ""
){
    fun openDetail(view:View){
        val intent = Intent(view.context, DetailActivity::class.java)
        intent.putExtra(TITLE, title)
        intent.putExtra(DATE, dateTaken)
        intent.putExtra(IMAGE, media.imageUrl)
        view.context.startActivity(intent)
    }
}

@BindingAdapter("setDate")
fun date(textView: AppCompatTextView, date: String) {
    textView.text = Utility.getFormattedDate(date)
}