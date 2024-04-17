package org.compose_projects.socialocal.core.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialocal.auth.presentation.LoginScreen
import org.compose_projects.socialocal.core.utils.Routes
import org.compose_projects.socialocal.core.viewModels.AccountViewModel
import org.compose_projects.socialocal.profile.domain.models.AccountEntity
import org.compose_projects.socialocal.navigation.NavHostControllerApp

@Composable
fun MainNavController(
    startDestination: String,
    accountViewModel: AccountViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    //dependiendo de cual sea el startDestination, mandará el usuario a /login o /home
    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.splashScreen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            )
        }

        composable(Routes.home) {
            NavHostControllerApp(
                accountViewModel
            )
        }

        composable(Routes.login) {
            LoginScreen() {
                //creamos el usuario en la tabla "account", esto solo ocurre la
                //primera vez que se registra un usuario
                accountViewModel.createAccount(
                    AccountEntity(
                        user = it
                    )
                )

            }
        }
    }
}