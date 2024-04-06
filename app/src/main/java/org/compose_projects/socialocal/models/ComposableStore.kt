package org.compose_projects.socialocal.models

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel

data class ComposableStore(
    val accountViewModel: AccountViewModel,
    val navHostController: NavHostController,
    val paddingValues: PaddingValues,
    val snackbarHostState: SnackbarHostState,
    val coroutineScope: CoroutineScope,
    val usersDao: UsersDBDao,
)
