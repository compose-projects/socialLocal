package org.compose_projects.socialocal.common.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.core.data.repository.NetworkRepository
import org.compose_projects.socialocal.core.model.Chat

abstract class CommonViewModel (private val networkRepository: NetworkRepository): ViewModel() {
    private val _chats = MutableStateFlow(listOf<Chat>())
    val chats = _chats.asStateFlow()

    val images = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4,
        R.drawable.avatar_5,
        R.drawable.avatar_6
    )
    fun getChats(){
        viewModelScope.launch (Dispatchers.IO){
            val devices= networkRepository.getActiveIpDevices()
            _chats.value = devices.map { ipDevice ->
                Chat(ipDevice = ipDevice, name = "", image = images.random() )
            }
        }
    }
}