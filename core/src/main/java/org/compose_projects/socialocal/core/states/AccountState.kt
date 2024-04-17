package org.compose_projects.socialocal.core.states

import org.compose_projects.socialocal.core.data.models.AccountEntity

data class AccountState(
     val listUsers: List<AccountEntity> = emptyList()
)
