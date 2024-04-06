package org.compose_projects.socialocal.profile.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import org.compose_projects.socialocal.auth.data.UsersDBDao
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.auth.data.model.Users
import org.compose_projects.socialocal.auth.presentation.states.UsersState
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dao: UsersDBDao
) : ViewModel() {
    var state by mutableStateOf(UsersState())
        private set

    private val _passwordLiveData = MutableLiveData<String>()
    val passwordLiveData: LiveData<String> = _passwordLiveData

    init {
        viewModelScope.launch {
            dao.getUsers().collectLatest {
                state = state.copy(
                    listUsers = it
                )
            }
        }
    }

    fun getPassword(username: String) =
        viewModelScope.launch {
            dao.getPassword(username).collect{
                it.password
            }
        }

    fun updateUri(id: Int, username: String, password: String, uri: String) =
        viewModelScope.launch {
            dao.updateUser(
                Users(
                    id = id,
                    user = username,
                    password = password,
                    //uri = uri
                )
            )
        }

}