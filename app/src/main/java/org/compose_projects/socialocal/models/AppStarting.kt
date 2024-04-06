package org.compose_projects.socialocal.models

import android.content.Context
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.presentation.LoginViewModel
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel
import org.compose_projects.socialocal.profile.presentation.ProfileViewModel

data class AppStarting (
    val loginViewModel: LoginViewModel,
    val accountViewModel: AccountViewModel,
    val startDestination: String,
    val usersDao: UsersDBDao
)
