package org.compose_projects.socialocal.models

import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.presentation.LoginViewModel
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel

data class AppStarting (
    val accountViewModel: AccountViewModel,
    val startDestination: String,
    val usersDao: UsersDBDao
)
