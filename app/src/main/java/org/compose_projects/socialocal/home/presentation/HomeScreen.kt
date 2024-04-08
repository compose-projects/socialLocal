package org.compose_projects.socialocal.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.compose_projects.socialocal.ui.components.TextExample
import org.compose_projects.socialocal.common.models.ComposableStore

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(composableStore: ComposableStore) {

    /*
    composableStore.coroutineScope.launch {
        composableStore.snackbarHostState.showSnackbar(
            message = "Ejemplo snack Bar",
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
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //AnimatedContentComponent(isVisible = isVisible)
            TextExample()
        }
    }

}

