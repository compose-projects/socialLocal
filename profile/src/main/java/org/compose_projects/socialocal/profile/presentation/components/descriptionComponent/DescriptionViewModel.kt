package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.core.data.daos.UsersDBDao
import org.compose_projects.socialocal.core.data.models.UsersEntity
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor(
    private val usersDBDao: UsersDBDao
) : ViewModel() {

    private val _userInfo = MutableLiveData<UsersEntity?>()
    val userInfo: MutableLiveData<UsersEntity?> = _userInfo

    fun getUser(user: String) =
        viewModelScope.launch {
            _userInfo.value = usersDBDao.getPassword(username = user).firstOrNull()
        }

    fun updateDescription(description: String, id: Int, user: String, password: String) =
        viewModelScope.launch {
            usersDBDao.updateUser(
                UsersEntity(
                    id = id,
                    user = user,
                    password = password,
                    description = description
                )
            )
        }


}