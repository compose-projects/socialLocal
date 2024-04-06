package org.compose_projects.socialocal.common.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.auth.data.UsersDBDao
import javax.inject.Inject

@HiltViewModel
class UserLoggedViewModel @Inject constructor(
    private val usersDBDao: UsersDBDao
) : ViewModel() {

    private val _userLogged = MutableStateFlow(false)
    val userLogged = _userLogged.asStateFlow()

    fun chechUserLogged() = viewModelScope.launch(Dispatchers.IO) {
        usersDBDao.getUsers().collect { listUsers ->

            if (listUsers.isNotEmpty()) {
                val user = listUsers[0]
                if (user.user.isNotEmpty() && user.password.isNotEmpty()) {
                    _userLogged.value = true

                } else {
                    _userLogged.value = false
                }
                Log.d("prueba18", "usuario XD: $listUsers")

            } else {
                _userLogged.value = false
            }

        }
    }
}
