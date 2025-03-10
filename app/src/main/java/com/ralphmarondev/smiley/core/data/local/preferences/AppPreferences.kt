package com.ralphmarondev.smiley.core.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(
    private val context: Context
) {
    companion object {
        private const val PREFERENCE_NAME = "preference_name"
        private const val FIRST_LAUNCH = "first_launch"
        private const val DARK_THEME = "dark_theme"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREFERENCE_NAME, Context.MODE_PRIVATE
    )

    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(FIRST_LAUNCH, true)
    }

    fun setFirstLaunchDone() {
        sharedPreferences.edit().putBoolean(FIRST_LAUNCH, false).apply()
    }

    fun isDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(DARK_THEME, false)
    }

    fun setDarkTheme() {
        sharedPreferences.edit().putBoolean(DARK_THEME, !isDarkTheme()).apply()
    }
}