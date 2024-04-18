package org.compose_projects.socialocal.home.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import org.compose_projects.socialocal.common.data.repository.NetworkRepository
import org.compose_projects.socialocal.common.viewModels.CommonViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (networkRepository: NetworkRepository): CommonViewModel(networkRepository) {


}