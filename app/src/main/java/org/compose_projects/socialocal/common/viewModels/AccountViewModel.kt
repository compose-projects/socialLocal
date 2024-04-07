package org.compose_projects.socialocal.common.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.profile.data.AccountDBDao
import org.compose_projects.socialocal.profile.domain.models.AccountEntity
import org.compose_projects.socialocal.profile.states.AccountState
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val userDao: AccountDBDao
): ViewModel() {
    var state by mutableStateOf(AccountState())
        private set

    init {
        viewModelScope.launch {
            userDao.getUser().collectLatest {
                state = state.copy(
                    listUsers = it
                )
            }
        }
    }

    //crear usuario en tabla account
    fun createAccount(user: AccountEntity) =
        viewModelScope.launch {
            userDao.addUser(user = user)
        }

    //actualizar usuario de tabla account
    fun updateAccount(user: AccountEntity) =
        viewModelScope.launch {
            userDao.updateUser(user = user)
        }
}