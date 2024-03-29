package com.zach.flicky.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zach.flicky.domain.database.doa.FeedDao
import com.zach.flicky.domain.database.entity.FeedEntry


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
@Database(entities = [FeedEntry::class], version = 1)
@TypeConverters(FeedConverter::class)
abstract class FlickyDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao


    companion object {
        @Volatile
        private var instance: FlickyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FlickyDatabase::class.java, "flicky.db"
            ).build()
    }
}