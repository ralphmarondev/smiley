package com.ralphmarondev.smiley.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.smiley.core.data.local.preferences.AppPreferences
import com.ralphmarondev.smiley.core.util.LocalThemeState
import com.ralphmarondev.smiley.features.home.presentation.HomeScreen
import com.ralphmarondev.smiley.features.settings.presentation.SettingScreen
import com.ralphmarondev.smiley.ui.theme.SmileyTheme

@Composable
fun AppNavigation(
    preferences: AppPreferences,
    navController: NavHostController = rememberNavController()
) {
    val themeState = LocalThemeState.current

    val startDestination: Any = when (preferences.isFirstLaunch()) {
        true -> Routes.Onboarding
        false -> Routes.Home
    }

    SmileyTheme(darkTheme = themeState.darkTheme.value) {
        NavHost(
            navController = navController,
            startDestination = Routes.Home
        ) {
            composable<Routes.Home> {
                HomeScreen(
                    navigateToSettings = {
                        navController.navigate(Routes.Settings) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Routes.Settings> {
                SettingScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}