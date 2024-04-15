package org.compose_projects.socialocal.auth.presentation.states

import org.compose_projects.socialocal.auth.data.model.UsersEntity


data class UsersState(
     val listUsers: List<UsersEntity> = emptyList()
)
