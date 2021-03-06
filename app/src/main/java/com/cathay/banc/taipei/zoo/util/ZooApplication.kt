package com.cathay.banc.taipei.zoo.util

import android.app.Application
import com.cathay.banc.taipei.zoo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class ZooApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            // android context
            androidContext(this@ZooApplication)
            // modules
            modules(
                arenaPresenterModule,
                plantPresenterModule,
                plantSearchConditionModule,
                repositoryModule,
                retrofitModule,
                zooApiModule,
            )
        }
    }
}
