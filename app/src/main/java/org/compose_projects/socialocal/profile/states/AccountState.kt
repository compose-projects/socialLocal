package org.compose_projects.socialocal.profile.states

import org.compose_projects.socialocal.profile.domain.models.Account

data class AccountState(
     val listUsers: List<Account> = emptyList()
)
