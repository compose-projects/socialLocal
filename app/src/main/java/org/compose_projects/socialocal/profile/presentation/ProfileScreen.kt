package org.compose_projects.socialocal.profile.presentation

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountsComponent
import org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent.ImageProfileComponent
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.SectionAccountsComponent
import kotlinx.coroutines.CoroutineScope
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.profile.navigation.ScreensProfile
import org.compose_projects.socialocal.models.ComposableStore
import org.compose_projects.socialocal.profile.presentation.components.accountComponent.AccountViewModel
import org.compose_projects.socialocal.profile.presentation.components.descriptionComponent.DescriptionComponent
import org.compose_projects.socialocal.profile.presentation.components.descriptionComponent.DescriptionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    composableStore: ComposableStore,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val sheetState = rememberModalBottomSheetState()

    /*scope.launch {
        snackbarHostState.showSnackbar(
            message = "hola perfil",
            duration = SnackbarDuration.Short,
            withDismissAction = true,
        )
    }

     */


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(composableStore.paddingValues)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            AccountsAndProfile(
                scope = composableStore.coroutineScope,
                sheetState = sheetState,
                content = {

                    SectionAccountsComponent(
                        profileViewModel,
                        accountViewModel = composableStore.accountViewModel
                    ) {
                        navController.navigate(ScreensProfile.Login.route)
                    }
                },
                accountViewModel = composableStore.accountViewModel,
                usersDBDao = composableStore.usersDao
            )

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsAndProfile(
    scope: CoroutineScope,
    sheetState: SheetState,
    accountViewModel: AccountViewModel,
    usersDBDao: UsersDBDao,
    content: @Composable () -> Unit
) {

    val user = accountViewModel.state.listUsers[0].user

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            AccountsComponent(
                scope = scope,
                sheetState = sheetState,
                content = {
                    content()
                },
                accountViewModel = accountViewModel
            )
            Spacer(modifier = Modifier.height(30.dp))

            ImageProfileComponent(
                accountViewModel = accountViewModel,
            )
            Spacer(modifier = Modifier.height(10.dp))

            DescriptionComponent(
                descriptionViewModel = DescriptionViewModel(usersDBDao),
                user = user,
                scope = scope,
            )

        }

    }
}


