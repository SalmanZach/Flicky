package com.zach.flicky.adapter

import androidx.recyclerview.widget.DiffUtil
import com.zach.flicky.R
import com.zach.flicky.domain.core.BaseRecyclerAdapter
import com.zach.flicky.domain.network.response.Feed


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class HomeFeedAdapter : BaseRecyclerAdapter<Feed>(Callback()) {


    class Callback : DiffUtil.ItemCallback<Feed>() {

        override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.dateTaken.equals(newItem.dateTaken, ignoreCase = true)
        }

        override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.title == newItem.title &&
                    oldItem.dateTaken == newItem.dateTaken &&
                    oldItem.media.imageUrl == newItem.media.imageUrl

        }

    }


    override fun getItemViewType(position: Int): Int {
            return R.layout.item_feed_home
    }


}