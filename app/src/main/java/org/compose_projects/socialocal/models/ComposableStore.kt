package org.compose_projects.socialocal.models

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.presentation.LoginViewModel
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel
import org.compose_projects.socialocal.profile.presentation.ProfileViewModel

data class ComposableStore(
    val loginViewModel: LoginViewModel,
    val accountViewModel: AccountViewModel,
    val navHostController: NavHostController,
    val paddingValues: PaddingValues,
    val snackbarHostState: SnackbarHostState,
    val coroutineScope: CoroutineScope,
    val usersDao: UsersDBDao,
)
