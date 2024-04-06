package org.compose_projects.socialocal.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.compose_projects.socialocal.ui.components.TextExample
import org.compose_projects.socialocal.models.ComposableStore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(composableStore: ComposableStore) {


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

