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
import org.compose_projects.socialocal.core.navigation.MainNavController
import org.compose_projects.socialocal.core.utils.Routes
import org.compose_projects.socialocal.core.presentation.theme.SocialLocalTheme

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {

    var startDestination by remember { mutableStateOf("") }

    val isUserLogged = mainViewModel.userLogged.collectAsState().value

    //verificar si el usuario está logueado
    LaunchedEffect(true) {
        this.launch {
            mainViewModel.chechUserLogged()
        }
    }

    //si está logueado entrar a la vista home
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