package org.compose_projects.socialocal.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialocal.common.viewModels.AccountViewModel
import org.compose_projects.socialocal.ui.components.TopAppBarComponent
import org.compose_projects.socialocal.ui.components.models.ComposableStore


@Composable
fun NavHostControllerApp(
    accountViewModel: AccountViewModel
) {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("") }
    var indexUpdate by remember { mutableStateOf(0) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopAppBarComponent(title = title) },
        bottomBar = {
            BottomAppNavigation(navController = navController)
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screens.Home.route /*Screens.Profile.route*/
        ) {

            Screens.items.forEach { menuItem ->

                composable(route = menuItem.route,
                    enterTransition = {
                        if (menuItem.index > indexUpdate) {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Start, tween(750)
                            )

                        } else if (menuItem.index == indexUpdate) {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Down, tween(200)
                            )
                        } else {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.End, tween(750)
                            )
                        }


                    }, popEnterTransition = {
                        if (menuItem.index > indexUpdate) {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Start, tween(750)
                            )
                        } else if (menuItem.index == indexUpdate) {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Down, tween(200)
                            )
                        } else {
                            return@composable slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.End, tween(750)
                            )
                        }

                    }
                ) {
                    title = menuItem.title
                    indexUpdate = menuItem.index
                    menuItem.screenComposable(
                        ComposableStore(
                            accountViewModel,
                            navController,
                            padding,
                            snackbarHostState,
                            scope,
                        )
                    )
                }
            }
        }
    }
}
