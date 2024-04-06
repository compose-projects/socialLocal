package org.compose_projects.socialocal.auth.presentation.states

import org.compose_projects.socialocal.auth.data.model.Users


data class UsersState(
     val listUsers: List<Users> = emptyList()
)
