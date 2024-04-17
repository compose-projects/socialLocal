package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DescriptionComponent(
    descriptionViewModel: DescriptionViewModel,
    user: String,
    scope: CoroutineScope,
) {

    var id by remember { mutableIntStateOf(0) }
    var password by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var showEditDescription by remember { mutableStateOf(false) }

    /*
    descriptionViewModel.updateDescription(
        description = "",
        id = 1,
        user = "",
        password = ""
    )

     */

    val userinfo = descriptionViewModel.userInfo.observeAsState(null).value

    scope.launch {
        descriptionViewModel.getUser(user)
    }

    LaunchedEffect(userinfo) {
        if (userinfo != null) {
            id = userinfo.id
            password = userinfo.password

            description = if (userinfo.description != null) {
                userinfo.description.toString()
            } else {
                ""
            }

        } else {
            //hacer algo cuando los valores sean nulos
        }
        /*
        Log.d("prueba18", "id: $id")
        Log.d("prueba18", "nombre: $user")
        Log.d("prueba18", "contraseña: $password")
         */
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.8F)
            .height(100.dp)
    ) {
        ContentDescriptionComponent(description) {
            //Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
            showEditDescription = true
        }
    }

    if (showEditDescription) {
        DialogEditDescription(
            description = description,
            onDismissRequest = { showEditDescription = false }) {
            descriptionViewModel.updateDescription(
                description = it,
                id = id,
                user = user,
                password = password
            )
            showEditDescription = false
        }
    }
}