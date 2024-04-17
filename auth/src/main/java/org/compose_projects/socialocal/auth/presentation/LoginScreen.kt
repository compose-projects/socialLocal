package org.compose_projects.socialocal.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialocal.core.R
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.auth.data.model.UsersEntity
import org.compose_projects.socialocal.auth.presentation.components.ButtonComponent
import org.compose_projects.socialocal.auth.presentation.components.LogoAppComponent
import org.compose_projects.socialocal.auth.presentation.components.TitleComponent
import org.compose_projects.socialocal.auth.presentation.components.UserAndPasswordComponent

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    top: Dp = 10.dp,
    paddingValues: PaddingValues = PaddingValues(10.dp),
    accountisVerified: (user: String) -> Unit
) {

    val context = LocalContext.current
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
        Scaffold(
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),

                ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.Center


                ) {
                    //RounderTextField()
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.8F)
                            .fillMaxWidth(0.9F)
                    ) {

                        Column(
                            Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            TitleComponent(title = R.string.title_create_account)

                            Spacer(modifier = Modifier.height(40.dp))

                            UserAndPasswordComponent(user = user, password = password,
                                userValueChange = {
                                    user = it
                                },
                                onClick = {
                                    user = ""
                                },
                                passwordValueChange = {
                                    password = it
                                }
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            ButtonComponent(user = user,
                                password = password,
                                context = context,
                                onClick = { user, password ->
                                    val createUser = UsersEntity(
                                        user = user,
                                        password = password
                                    )

                                    if (user.isNotEmpty() && password.isNotEmpty()) {

                                        loginViewModel.createAccount(
                                            user = createUser,
                                            context = context
                                        )

                                        accountisVerified(user)

                                    } else {
                                        scope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Usuario u contraseña son vacios, ocúpelos antes de continuar.",
                                                withDismissAction = true,
                                                duration = SnackbarDuration.Long
                                            )
                                        }
                                    }

                                }
                            )
                        }
                    }
                }

                LogoAppComponent(top = top)
            }
        }
    }
}
