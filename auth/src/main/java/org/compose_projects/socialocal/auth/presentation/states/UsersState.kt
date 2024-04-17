package org.compose_projects.socialocal.auth.presentation.states

import org.compose_projects.socialocal.core.data.models.UsersEntity


data class UsersState(
     val listUsers: List<UsersEntity> = emptyList()
)
