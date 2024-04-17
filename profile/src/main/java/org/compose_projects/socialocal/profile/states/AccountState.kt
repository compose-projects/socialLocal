package org.compose_projects.socialocal.profile.states

import org.compose_projects.socialocal.profile.domain.models.AccountEntity

data class AccountState(
     val listUsers: List<AccountEntity> = emptyList()
)
