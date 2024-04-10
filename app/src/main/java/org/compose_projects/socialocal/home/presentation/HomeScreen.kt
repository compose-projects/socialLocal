package org.compose_projects.socialocal.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.common.domain.model.Chat
import org.compose_projects.socialocal.ui.models.ComposableStore
import org.compose_projects.socialocal.common.domain.model.IpDevice

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(composableStore: ComposableStore, viewModel: HomeViewModel = hiltViewModel()) {

    /*
    composableStore.coroutineScope.launch {
        composableStore.snackbarHostState.showSnackbar(
            message = "Ejemplo snack Bar",
            duration = SnackbarDuration.Short,
            withDismissAction = true,
        )
    }

     */
    LaunchedEffect(key1 = true) {
        viewModel.getChats()
    }

    val chats by viewModel.chats.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(composableStore.paddingValues),
    ) {

        SearchItem()

        if (chats.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn {
                items(chats, key = { it.toString() }) {
                    DeviceItem(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp), it
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                }
            }

        }

        /*
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //AnimatedContentComponent(isVisible = isVisible)
            TextExample()
        }
        */
    }

}

@Composable
fun DeviceItem(modifier: Modifier = Modifier, chat: Chat) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        CircularImage(image = chat.image)
        Spacer(modifier = Modifier.width(10.dp))
        Text(chat.ipDevice.toString())
    }
}


@Composable
fun CircularImage(modifier: Modifier = Modifier, image: Int) {

    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .size(60.dp)
            .background(shape = CircleShape, color = Color.Transparent) // Apply circular shape
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchItem() {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        Modifier
            .semantics { isTraversalGroup = true }) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = -1f },
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = {
                active = it
            },
            colors = SearchBarDefaults.colors(
                containerColor = SearchBarDefaults.colors().containerColor.copy(alpha = 0.5f)

            ),
            placeholder = { Text("Hinted search text") },
            leadingIcon = {
                IconButton(onClick = { active = false }) {
                    Icon(
                        if (!active) Icons.Default.Search else Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
        ) {
            repeat(4) { idx ->
                val resultText = "Suggestion $idx"
                ListItem(
                    headlineContent = { Text(resultText) },
                    supportingContent = { Text("Additional info") },
                    leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
                    modifier = Modifier
                        .clickable {
                            text = resultText
                            active = false
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }

        /*
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = List(100) { "Text $it" }
            items(count = list.size) {
                Text(
                    list[it],
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }

         */
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFB2DFDB
)
@Composable
fun PrevSearchItem() {
    SearchItem()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFB2DFDB
)
@Composable
fun PrevDeviceItem() {
    val images = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4,
        R.drawable.avatar_5,
        R.drawable.avatar_6
    )
    val devices = (1..20).map {
        Chat(
            ipDevice =
            IpDevice(192, 168, 1, it, true), image = images.random(),
            name = ""
        )
    }
    LazyColumn {
        items(devices, key = { it.toString() }) {
            DeviceItem(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), it
            )
            Spacer(modifier = Modifier.height(5.dp))
        }


    }
}