package com.zach.flicky.domain.repository

import androidx.lifecycle.LiveData
import com.zach.flicky.domain.dataSource.FlickyDataSource
import com.zach.flicky.domain.database.doa.FeedDao
import com.zach.flicky.domain.database.entity.FeedEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class FlickyRepositoryImp (
    private val feedDao: FeedDao,
    private val dataSource: FlickyDataSource
):FlickerRepository {

    init {

        dataSource.apply {
            downloadedFeeds.observeForever { data ->
                persistFetchedFeed(data)
            }
        }

    }

    override suspend fun loadFeeds(tag: String) {
         dataSource.fetchFeedsData(tag)
    }

    override suspend fun getFeedByTag(tag: String): LiveData<FeedEntry> {
        return withContext(Dispatchers.IO) {
            return@withContext feedDao.getFeedByTag(tag)
        }
    }


    private fun persistFetchedFeed(feeds: FeedEntry) {
        GlobalScope.launch(Dispatchers.IO) {
            feedDao.deleteAll(feeds.tag)
            feedDao.insertFeeds(feeds)
        }
    }


}