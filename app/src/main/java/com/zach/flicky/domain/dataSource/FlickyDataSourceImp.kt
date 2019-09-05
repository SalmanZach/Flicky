package com.zach.flicky.domain.dataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.zach.flicky.domain.Constants
import com.zach.flicky.domain.network.FlickyService
import com.zach.flicky.domain.database.entity.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class FlickyDataSourceImp(private val flickyService: FlickyService) :FlickyDataSource{


    private val _downloadedFeeds = MediatorLiveData<List<Feed>>()
    override val downloadedFeeds: LiveData<List<Feed>>
        get() = _downloadedFeeds

    override suspend fun fetchFeedsData(tag:String) {
        withContext(Dispatchers.IO) {
            try {
                val fetchedData = flickyService.getFeedsAsync(tag,1,"json").await()

                 fetchedData.feeds.forEach {
                     it.tag = tag
                 }
                _downloadedFeeds.postValue(fetchedData.feeds)
            } catch (e: Exception) {
                Timber.d(e.message)
            }
        }
    }
}