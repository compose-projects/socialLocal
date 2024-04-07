package org.compose_projects.socialocal.main.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.common.viewModels.UserLoggedViewModel
import org.compose_projects.socialocal.common.navigation.MainNavController
import org.compose_projects.socialocal.common.utils.Routes
import org.compose_projects.socialocal.ui.theme.SocialLocalTheme

@Composable
fun MainScreen(
    userLoggedViewModel: UserLoggedViewModel = hiltViewModel(),
) {

    var startDestination by remember { mutableStateOf("") }

    val isUserLogged = userLoggedViewModel.userLogged.collectAsState().value

    LaunchedEffect(true) {
        this.launch {
            userLoggedViewModel.chechUserLogged()
        }
    }

    startDestination = if (isUserLogged) {
        Routes.home
    } else {
        Routes.login
    }

    SocialLocalTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            MainNavController(
                startDestination = startDestination,
            )

        }
    }
}