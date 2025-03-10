package com.ralphmarondev.smiley.navigation

import kotlinx.serialization.Serializable

object Routes {

    @Serializable
    data object Onboarding

    @Serializable
    data object Home

    @Serializable
    data object Settings
}