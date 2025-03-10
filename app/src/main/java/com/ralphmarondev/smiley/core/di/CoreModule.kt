package com.ralphmarondev.smiley.core.di

import com.ralphmarondev.smiley.core.data.local.preferences.AppPreferences
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreModule = module {
    singleOf(::AppPreferences)
}