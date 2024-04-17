package org.compose_projects.socialocal.inbox.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.compose_projects.socialocal.core.presentation.components.bottom_chat.SLBottomChat
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.SLChatBubbles
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message1
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message10
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message11
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message12
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message2
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message3
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message4
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message5
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message6
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message7
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message8
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages.message9
import org.compose_projects.socialocal.core.presentation.components.chat_bubbles.test.messages_example
import org.compose_projects.socialocal.core.presentation.models.ComposableStore

@Composable
fun InboxScreen(composableStore: ComposableStore) {
    var textChat by remember { mutableStateOf("") }
    val messages: List<messages_example> = listOf(
        message1,
        message2,
        message3,
        message4,
        message5,
        message6,
        message7,
        message8,
        message9,
        message10,
        message11,
        message12
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(composableStore.paddingValues)
    ) {

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            items(messages) {
                SLChatBubbles(message = it.message, left = it.left)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        SLBottomChat(
            value = textChat,
            onValueChange = { textChat = it },
            fileOpen = { /*TODO*/ },
            photoOpen = {},
            send = {}
        )
    }
}