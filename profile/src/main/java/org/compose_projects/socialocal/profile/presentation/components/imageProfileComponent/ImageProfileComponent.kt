package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.core.viewModels.AccountViewModel

const val PREFIX_IMAGE = "_profile.jpeg"

@Composable
fun ImageProfileComponent(
    accountViewModel: AccountViewModel,
    imageViewModel: ImageProfileViewModel = viewModel()
) {

    val context = LocalContext.current
    val userLogged = accountViewModel.state.listUsers[0].user
    val imageExists = imageViewModel.imageExists.observeAsState(false).value
    val imageLoaded = imageViewModel.imageLoaded.observeAsState(null).value

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    var nameImage by remember { mutableStateOf("") }
    var showImageScaled by remember { mutableStateOf(false) }

    val imagePainter = if (imageLoaded != null) BitmapPainter(imageLoaded.asImageBitmap())
                    else painterResource(id = R.drawable.ic_launcher_background)

    LaunchedEffect(userLogged){
        //Log.d("prueba17", userLogged)
        nameImage = userLogged
        with(imageViewModel) {
            checkImageExistence(context, imageName = nameImage + PREFIX_IMAGE)
            loadImage(context, imageName = nameImage + PREFIX_IMAGE)
        }
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            selectedImageUri.value = it
            imageViewModel.saveImage(context, uri = it, nameImage = nameImage + PREFIX_IMAGE)
        }
    }

    Image(
        painter = imagePainter,
        contentDescription = if (imageLoaded != null) "Loaded image" else null,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .clickable {
                showImageScaled = true
            },
        contentScale = ContentScale.FillBounds,
    )

    ShowImageScaled(
        selectedImageUri = selectedImageUri,
        show = showImageScaled,
        onDismissRequest = {
            showImageScaled = false
        },
        context = context,
        imageExists = imageExists, //Toast.makeText(context, "Imagen existente", Toast.LENGTH_SHORT).show()
        imageLoaded = imageLoaded,
        editImage = { launcher.launch("image/*") },
        deleteImage = {
            imageViewModel.deleteImage(
                context = context,
                imageName = nameImage + PREFIX_IMAGE
            )
        }
    )
}