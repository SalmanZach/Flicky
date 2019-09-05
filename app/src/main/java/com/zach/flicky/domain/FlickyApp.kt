package com.zach.flicky.domain

import android.app.Application
import com.zach.flicky.domain.database.FlickyDatabase
import com.zach.flicky.domain.network.ServiceGenerator
import com.zach.flicky.domain.dataSource.FlickyDataSource
import com.zach.flicky.domain.dataSource.FlickyDataSourceImp
import com.zach.flicky.domain.repository.FlickerRepository
import com.zach.flicky.domain.repository.FlickyRepositoryImp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

class FlickyApp:Application(),KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@FlickyApp))

        bind() from singleton { FlickyDatabase(instance()) }
        bind() from singleton { instance<FlickyDatabase>().feedDao() }
        bind() from singleton { ServiceGenerator() }
        bind<FlickyDataSource>() with singleton { FlickyDataSourceImp(instance()) }
        bind<FlickerRepository>() with singleton {
            FlickyRepositoryImp(instance(),instance())}
        bind() from provider { ViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()

    }
}