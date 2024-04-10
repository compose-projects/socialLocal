package org.compose_projects.socialocal.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.common.data.repository.NetworkRepository
import org.compose_projects.socialocal.common.viewModels.CommonViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (networkRepository: NetworkRepository): CommonViewModel(networkRepository) {


}