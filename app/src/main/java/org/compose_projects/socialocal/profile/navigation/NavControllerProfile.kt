package org.compose_projects.socialocal.profile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialocal.ui.models.ComposableStore

@Composable
fun NavControllerProfile(
    composableStore: ComposableStore
) {
    val navController = rememberNavController()

    val items = listOf(ScreensProfile.Profile, ScreensProfile.Login)

    NavHost(navController = navController, startDestination = items[0].route) {

        items.forEach { screen ->
            composable(screen.route) {
                screen.screenComposable(
                    navHostControlller = navController,
                    composableStore = composableStore
                )
            }
        }

    }

}