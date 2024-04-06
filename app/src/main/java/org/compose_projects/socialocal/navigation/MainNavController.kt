package org.compose_projects.socialocal.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialocal.auth.presentation.LoginScreen
import org.compose_projects.socialocal.profile.domain.models.Account
import org.compose_projects.socialocal.models.AppStarting
import org.compose_projects.socialocal.ui.navigation.NavHostControllerApp

@Composable
fun MainNavController(
    appStarting: AppStarting
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = appStarting.startDestination) {

        composable("/") {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black))
        }

        composable("/home") {
            NavHostControllerApp(
                appStarting
            )
        }
        composable("/login") {
            LoginScreen(
                loginViewModel = appStarting.loginViewModel,
            ) {
                appStarting.accountViewModel.account(
                    Account(
                        user = it
                    ),
                )
            }
        }
    }
}