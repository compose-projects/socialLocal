package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.data.model.Users

class DescriptionViewModel(private val usersDBDao: UsersDBDao) : ViewModel() {

    private val _userInfo = MutableLiveData<Users?>()
    val userInfo: MutableLiveData<Users?> = _userInfo

    fun getUser(user: String) =
        viewModelScope.launch {
            _userInfo.value = usersDBDao.getPassword(username = user).firstOrNull()
        }

    fun updateDescription(description: String, id: Int, user: String, password: String) =
        viewModelScope.launch {
            usersDBDao.updateUser(
                Users(
                    id = id,
                    user = user,
                    password = password,
                    description = description
                )
            )
        }


}