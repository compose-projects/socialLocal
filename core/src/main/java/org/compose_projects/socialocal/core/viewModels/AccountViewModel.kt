package org.compose_projects.socialocal.core.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.core.data.daos.AccountDBDao
import org.compose_projects.socialocal.core.data.models.AccountEntity
import org.compose_projects.socialocal.core.states.AccountState
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val userDao: AccountDBDao
): ViewModel() {

    //lista de el usuario en tiempo real
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

    //borrar usuario de tabla account
    fun deleteAccount(user: AccountEntity) =
        viewModelScope.launch {
            userDao.deleteUser(user = user)
        }

}