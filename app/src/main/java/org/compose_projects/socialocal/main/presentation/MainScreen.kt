package org.compose_projects.socialocal.main.presentation

import android.content.Context
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.room.Room
import org.compose_projects.socialocal.profile.presentation.ProfileViewModel
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.auth.data.UsersDB
import org.compose_projects.socialocal.auth.presentation.LoginViewModel
import org.compose_projects.socialocal.common.viewModels.UserLoggedViewModel
import org.compose_projects.socialocal.navigation.MainNavController
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel
import org.compose_projects.socialocal.models.AppStarting
import org.compose_projects.socialocal.ui.theme.SocialLocalTheme

@Composable
fun MainScreen(userLoggedViewModel: UserLoggedViewModel = hiltViewModel()) {

    var startDestination by remember { mutableStateOf("/") }

    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        UsersDB::class.java,
        "db_usuarios"
    ).build()

    val usersDao = db.UsersDao()
    val accountDao = db.AccountDao()

    val accountViewModel = AccountViewModel(userDao = accountDao)


    val isUserLogged = userLoggedViewModel.userLogged.collectAsState().value

    LaunchedEffect(true) {
        userLoggedViewModel.chechUserLogged()
    }

    startDestination = if (isUserLogged) {
        "/home"
    } else {
        "/login"
    }


    SocialLocalTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            MainNavController(
                appStarting = AppStarting(
                    accountViewModel = accountViewModel,
                    startDestination = startDestination,
                    usersDao = usersDao
                )
            )
        }

    }
}