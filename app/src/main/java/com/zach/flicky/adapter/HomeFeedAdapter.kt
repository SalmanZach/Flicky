package com.zach.flicky.adapter

import androidx.recyclerview.widget.DiffUtil
import com.zach.flicky.R
import com.zach.flicky.domain.core.BaseRecyclerAdapter
import com.zach.flicky.domain.database.entity.Feed


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class HomeFeedAdapter : BaseRecyclerAdapter<Feed>(Callback()) {


    class Callback : DiffUtil.ItemCallback<Feed>() {

        override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.authorId.equals(newItem.authorId, ignoreCase = true)
        }

        override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.authorId == newItem.authorId &&
                    oldItem.title == newItem.title &&
                    oldItem.dateTaken == newItem.dateTaken &&
                    oldItem.published == newItem.published

        }

    }


    override fun getItemViewType(position: Int): Int {
            return R.layout.item_feed_home
    }


}