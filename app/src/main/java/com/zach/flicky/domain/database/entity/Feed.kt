package com.zach.flicky.domain.database.entity


import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.zach.flicky.domain.network.response.Media
import com.zach.flicky.ui.activity.DATE
import com.zach.flicky.ui.activity.DetailActivity
import com.zach.flicky.ui.activity.IMAGE
import com.zach.flicky.ui.activity.TITLE
import com.zach.flicky.utility.Utility



/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

@Entity
data class Feed(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("date_taken")
    var dateTaken: String = "",
    var tag:String,
    @SerializedName("author_id")
    var authorId: String = "",
    @SerializedName("author")
    var author: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("link")
    var link: String = "",
    @SerializedName("media")
    @Embedded(prefix = "media_")
    var media: Media = Media(),
    @SerializedName("published")
    var published: String = "",
    @SerializedName("tags")
    var tags: String = "",
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