package org.compose_projects.socialocal.auth.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class LoginViewModel @Inject constructor(
    private val dao: UsersDBDao
) : ViewModel() {

    var state by mutableStateOf(UsersState())
        private set

    init {
        viewModelScope.launch {
            dao.getUsers().collectLatest {
                state = state.copy(
                    listUsers = it
                )
            }
        }
    }


    fun createAccount(user: Users, context: Context) =
        //Toast.makeText(context, "usuario: $user, contraseña: $password", Toast.LENGTH_SHORT).show()
        viewModelScope.launch {
            dao.addUser(user = user)
            Toast.makeText(context, "Bienvenido(a)! ${user.user}", Toast.LENGTH_LONG).show()

        }

    fun deleteAccount(user: Users, context: Context) =
        //Toast.makeText(context, "usuario: $user, contraseña: $password", Toast.LENGTH_SHORT).show()
        viewModelScope.launch {
            dao.deleteUser(user = user)
        }

    fun updateAccount(user: Users, context: Context) =
        //Toast.makeText(context, "usuario: $user, contraseña: $password", Toast.LENGTH_SHORT).show()
        viewModelScope.launch {
            dao.updateUser(user = user)
        }

}