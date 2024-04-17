package org.compose_projects.socialocal.profile.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetsComponent(
    scope: CoroutineScope,
    showBottomSheet: Boolean,
    sheetState: SheetState,
    onDissRequests: () -> Unit,
    content: @Composable () -> Unit,
    contenColor: Color = MaterialTheme.colorScheme.onSecondary
) {

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                onDissRequests()
            },
            sheetState = sheetState,
            modifier = Modifier
                .fillMaxHeight(0.5F)
                .padding(bottom = 40.dp),
            containerColor = contenColor
        ) {
            // Sheet content
            content()
        }
    }

}