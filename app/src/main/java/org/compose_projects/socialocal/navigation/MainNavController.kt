package org.compose_projects.socialocal.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var startDestination by remember {
        mutableStateOf("/")
    }

    LaunchedEffect(appStarting.startDestination){
        startDestination = appStarting.startDestination
    }

    NavHost(navController = navController, startDestination = startDestination) {

        composable("/") {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            )
        }

        composable("/home") {
            NavHostControllerApp(
                appStarting
            )
        }
        composable("/login") {
            LoginScreen() {
                appStarting.accountViewModel.account(
                    Account(
                        user = it
                    )
                )
            }
        }
    }
}