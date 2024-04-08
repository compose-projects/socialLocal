package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.common.viewModels.AccountViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ImageProfileComponent(
    accountViewModel: AccountViewModel,
    imageViewModel: ImageProfileViewModel = ImageProfileViewModel()
) {

    val context = LocalContext.current
    var nameImage by remember { mutableStateOf("") }
    val prefixImage = "_profile.jpeg"

    val userLogged = accountViewModel.state.listUsers[0].user
    LaunchedEffect(userLogged){
        //Log.d("prueba17", userLogged)
        nameImage = userLogged
    }

    var showImageScaled by remember { mutableStateOf(false) }
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            selectedImageUri.value = uri
            imageViewModel.saveImage(context, uri = uri, nameImage = nameImage+prefixImage)
        }
    }


    val imageExists = imageViewModel.imageExists.observeAsState(false).value
    val imageLoaded = imageViewModel.imageLoaded.observeAsState(null).value
    val scope = rememberCoroutineScope()

    scope.launch {
        imageViewModel.checkImageExistence(context, imageName = nameImage+prefixImage)
        imageViewModel.loadImage(context, imageName = nameImage+prefixImage)
    }


    if (imageExists) {
        //Toast.makeText(context, "Imagen existente", Toast.LENGTH_SHORT).show()
        if (imageLoaded != null) {
            Image(
                bitmap = imageLoaded!!.asImageBitmap(), contentDescription = "Loaded image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .clickable {
                        showImageScaled = true
                    },
                contentScale = ContentScale.FillBounds,
            )
        }else{
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .clickable {
                        showImageScaled = true
                    },
                contentScale = ContentScale.FillBounds,
            )
        }

    } else {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .clickable {
                    showImageScaled = true
                },
            contentScale = ContentScale.FillBounds,
        )
    }

    ShowImageScaled(
        selectedImageUri,
        show = showImageScaled,
        onDismissRequest = {
            showImageScaled = false

        },
        context = context,
        imageExists = imageExists,
        imageLoaded = imageLoaded,
    ) {

        launcher.launch("image/*")
    }

}



@Composable
fun BottomContent(editImage: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.height(47.dp)
        ) {
            BottomAppBarContent(editImage = { editImage() })
        }
    }
}



