package org.compose_projects.socialocal.profile.presentation.components.accountComponent

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.profile.data.AccountDBDao
import org.compose_projects.socialocal.profile.domain.models.Account
import org.compose_projects.socialocal.profile.states.AccountState

class AccountViewModel(private val userDao: AccountDBDao): ViewModel() {
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
    fun account(user: Account) =
        viewModelScope.launch {
            userDao.addUser(user = user)
        }

    //actualizar usuario de tabla account
    fun updateAccount(user: Account) =
        viewModelScope.launch {
            userDao.updateUser(user = user)
        }
}