package org.compose_projects.socialocal.profile.presentation.components.imageProfileComponent.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.compose_projects.socialocal.R

@Composable
fun FullImageView(
    imageLoaded: Bitmap?,
    userName: String,
    onDismissImage: () -> Unit
) {
    val profileImage = if (imageLoaded != null) BitmapPainter(imageLoaded.asImageBitmap())
    else painterResource(id = R.drawable.ic_launcher_background)

    Dialog(
        onDismissRequest = { onDismissImage() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Scaffold(
            topBar = {
                FullImageTopBar(
                    userName = userName,
                    onDismissImage = onDismissImage
                )
            }
        ) {
            FullImageContent(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                profileImage = profileImage
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun FullImageTopBar(userName: String, onDismissImage: () -> Unit) {
    TopAppBar(
        title = { Text(text = userName) },
        navigationIcon = {
            IconButton(onClick = { onDismissImage() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.clickable { onDismissImage() }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        )
    )
}

@Composable
private fun FullImageContent(
    modifier: Modifier,
    profileImage: Painter
) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember { mutableFloatStateOf(1f) }

    Box(
        modifier = modifier
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale = maxOf(1f, minOf(scale * zoom, 5f))
                    val maxX = (size.width * (scale - 1)) / 2
                    val minX = -maxX
                    offsetX = maxOf(minX, minOf(maxX, offsetX + pan.x))
                    val maxY = (size.height * (scale - 1)) / 2
                    val minY = -maxY
                    offsetY = maxOf(minY, minOf(maxY, offsetY + pan.y))
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = profileImage,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = maxOf(.5f, minOf(3f, scale)),
                    scaleY = maxOf(.5f, minOf(3f, scale)),
                    translationX = offsetX,
                    translationY = offsetY
                ),
        )
    }
}