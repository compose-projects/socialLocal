package org.compose_projects.socialocal.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.compose_projects.socialocal.home.presentation.HomeScreen
import org.compose_projects.socialocal.inbox.presentation.InboxScreen
import org.compose_projects.socialocal.profile.navigation.NavControllerProfile
import org.compose_projects.socialocal.common.models.ComposableStore
import org.compose_projects.socialocal.common.utils.Routes

sealed class Screens(
    val icon: ImageVector,
    val route: String,
    val title: String,
    val name: String,
    val contentDescription: String,
    val index: Int,
    val screenComposable: @Composable (
        ComposableStore
    ) -> Unit
) {

    data object Home : Screens(
        icon = Icons.Filled.Home,
        route = Routes.home,
        title = "Inicio",
        name = "Inicio",
        contentDescription = "Home",
        index = 0,
        screenComposable = { composableStore ->
            HomeScreen(
                composableStore
            )
        }
    )

    data object Inbox : Screens(
        icon = Icons.Filled.Email,
        route = Routes.inbox,
        title = "Bandeja de entrada",
        name = "Inbox",
        contentDescription = "Mensajes",
        index = 1,
        screenComposable = { composableStore  ->
            InboxScreen(
                composableStore
            )
        }
    )


    data object Profile : Screens(
        icon = Icons.Filled.AccountCircle,
        route = Routes.profile,
        title = "Perfil",
        name = "Perfil",
        contentDescription = "Configuración",
        index = 2,
        screenComposable = { composableStore ->
            NavControllerProfile(
                composableStore
            )
        }
    )

    companion object {
        val items = listOf(Home, Inbox, Profile)
    }

}

