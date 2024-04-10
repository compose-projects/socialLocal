package org.compose_projects.socialocal.inbox.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.compose_projects.socialocal.ui.components.TextExample
import org.compose_projects.socialocal.ui.components.models.ComposableStore

@Composable
fun InboxScreen(composableStore: ComposableStore) {
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