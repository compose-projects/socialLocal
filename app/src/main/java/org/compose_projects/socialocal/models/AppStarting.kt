package org.compose_projects.socialocal.models

import org.compose_projects.socialocal.common.viewModels.AccountViewModel

data class AppStarting (
    val accountViewModel: AccountViewModel,
    val startDestination: String,
)
