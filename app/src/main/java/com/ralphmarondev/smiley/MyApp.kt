package com.ralphmarondev.smiley

import android.app.Application
import com.ralphmarondev.smiley.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(coreModule)
        }
    }
}