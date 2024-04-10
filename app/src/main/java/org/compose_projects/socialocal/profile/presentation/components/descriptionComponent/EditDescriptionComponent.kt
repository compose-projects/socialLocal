package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.Dialog
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.ui.components.textField.TextFieldComponent
import org.compose_projects.socialocal.ui.components.textField.styles.TextFieldSizes
import org.compose_projects.socialocal.ui.components.textField.styles.TextFieldColors


@Composable
fun DialogEditDescription(
    description: String,
    onDismissRequest: () -> Unit,
    onCLick: (String) -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4F)
                .fillMaxWidth(0.8F)
        ) {
            ContentDialog(description) {
                onCLick(it)
            }
        }
    }
}


@Composable
fun ContentDialog(description: String, onCLick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.2F)),
        contentAlignment = Alignment.Center
    ) {
        EditDescriptionComponent(description = description) {
            onCLick(it)
        }
    }
}

@Composable
fun EditDescriptionComponent(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    description: String,
    onCLick: (String) -> Unit
) {

    var descriptionNew by remember { mutableStateOf(description) }
    Column {

        TextFieldComponent(
            colors = if (!useDarkTheme) TextFieldColors.defaultStyleLight else TextFieldColors.defaultStyleDark,
            sizes = TextFieldSizes.descriptionSize,
            value = descriptionNew,
            keyboardActions = {
                onCLick(descriptionNew)
            },
            onValueChange = {
                descriptionNew = it
            }, placeholder = {
                Text(
                    text = stringResource(id = R.string.edit_description), style = TextStyle(
                        color = MaterialTheme.colorScheme.background.copy(alpha = 0.5F),
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        )
        Text(text = "(${descriptionNew.length}/150)")
    }

}