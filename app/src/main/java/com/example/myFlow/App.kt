package com.example.myFlow

import android.app.Application
import com.example.myFlow.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    repoModule,
                    viewModelModule,
                    dataSourceModule,
                )
            )
        }
    }
}