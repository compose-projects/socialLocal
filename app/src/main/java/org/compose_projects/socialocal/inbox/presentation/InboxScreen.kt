package org.compose_projects.socialocal.inbox.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.compose_projects.socialocal.ui.components.TextExample
import org.compose_projects.socialocal.ui.components.bottom_chat.SLBottomChat
import org.compose_projects.socialocal.ui.models.ComposableStore

@Composable
fun InboxScreen(composableStore: ComposableStore) {
    var textChat by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(composableStore.paddingValues)
    ) {
        SLBottomChat(
            value = textChat,
            onValueChange = { textChat = it },
            fileOpen = { /*TODO*/ },
            photoOpen = {},
            send = {}
        )
    }
}