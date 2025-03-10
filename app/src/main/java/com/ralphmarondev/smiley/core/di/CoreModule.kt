package com.ralphmarondev.smiley.core.di

import android.content.Context
import androidx.work.WorkManager
import com.ralphmarondev.smiley.core.data.local.preferences.AppPreferences
import com.ralphmarondev.smiley.core.notification.AppNotification
import com.ralphmarondev.smiley.core.util.ThemeState
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreModule = module {
    singleOf(::AppPreferences)
    singleOf(::ThemeState)

    singleOf(::provideWorkManager)
    factoryOf(::AppNotification)
}

fun provideWorkManager(context: Context): WorkManager {
    return WorkManager.getInstance(context)
}