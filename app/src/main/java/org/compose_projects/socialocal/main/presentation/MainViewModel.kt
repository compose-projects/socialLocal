package org.compose_projects.socialocal.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel (): ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()


    private val _userLogged = MutableStateFlow(false)
    val userLogged = _userLogged.asStateFlow()

    init {
        viewModelScope.launch {
            delay(100L)
            _isReady.value = true

        }
    }

}