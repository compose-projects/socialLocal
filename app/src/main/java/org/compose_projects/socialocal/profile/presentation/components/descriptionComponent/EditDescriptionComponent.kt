package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.ui.components.TextFieldComponent
import org.compose_projects.socialocal.auth.presentation.components.TextStyleComponent


@Composable
fun DialogEditDescription(description: String, onDismissRequest: () -> Unit, onCLick: (String) -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4F)
                .fillMaxWidth(0.8F)
        ) {
            ContentDialog(description){
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
        EditDescriptionComponent(description){
            onCLick(it)
        }
    }
}

@Composable
fun EditDescriptionComponent(description: String, onCLick: (String) -> Unit) {

    var descriptionNew by remember { mutableStateOf(description) }
    Column {

        TextFieldComponent(
            value = descriptionNew,
            shape = RoundedCornerShape(7.dp),
            maxLines = 4,
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
            },
            contenedorEnfocado = MaterialTheme.colorScheme.onPrimary,
            textStyle = TextStyleComponent(
                color = MaterialTheme.colorScheme.background,
                fontSize = 13.sp,
                font = Font(R.font.cabrito),
                fontWight = FontWeight.ExtraBold
            ),
            maxChar = 150,
            height = 100.dp

        )

        Text(text = "(${descriptionNew.length}/150)")

    }
    
}