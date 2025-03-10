package com.ralphmarondev.smiley

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.smiley.core.data.local.preferences.AppPreferences
import com.ralphmarondev.smiley.core.notification.requestNotificationPermission
import com.ralphmarondev.smiley.core.util.ThemeProvider
import com.ralphmarondev.smiley.core.util.ThemeState
import com.ralphmarondev.smiley.navigation.AppNavigation
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val preferences: AppPreferences by inject()
    private val themeState: ThemeState by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        requestNotificationPermission(activity = this@MainActivity)
        setContent {
            ThemeProvider(themeState = themeState) {
                AppNavigation(preferences)
            }
        }
    }
}