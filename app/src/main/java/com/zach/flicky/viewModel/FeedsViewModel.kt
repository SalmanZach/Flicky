package com.zach.flicky.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zach.flicky.domain.database.entity.Feed
import com.zach.flicky.domain.repository.FlickerRepository
import com.zach.flicky.utility.lazyDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class FeedsViewModel(private val repository: FlickerRepository) : ViewModel(){


    fun getFeedByTagAsync(tag: String): Deferred<LiveData<List<Feed>>> {
        val feeds by lazyDeferred {
            repository.getFeedByTag(tag)
        }
        return feeds
    }

    fun loadFeedByTag(tag: String) {
        GlobalScope.launch {
            repository.loadFeeds(tag)
        }
    }



}