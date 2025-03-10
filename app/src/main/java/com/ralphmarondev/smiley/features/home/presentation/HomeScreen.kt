package com.ralphmarondev.smiley.features.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ralphmarondev.smiley.core.util.LocalThemeState
import com.ralphmarondev.smiley.features.home.presentation.components.DrawerContent
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navigateToSettings: () -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent()
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { HomeScreenTopAppBar(drawerState) }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Home Screen")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenTopAppBar(
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val themeState = LocalThemeState.current

    TopAppBar(
        title = {
            Text(
                text = "Smiley"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.MenuOpen,
                    contentDescription = "Open navigation drawer"
                )
            }
        },
        actions = {
            IconButton(onClick = themeState::toggleTheme) {
                val imageVector = when (themeState.darkTheme.value) {
                    true -> Icons.Outlined.LightMode
                    false -> Icons.Outlined.DarkMode
                }

                Icon(
                    imageVector = imageVector,
                    contentDescription = "Theme toggle"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}