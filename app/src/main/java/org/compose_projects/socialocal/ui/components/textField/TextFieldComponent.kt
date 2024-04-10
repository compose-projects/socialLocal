package org.compose_projects.socialocal.ui.components.textField

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldComponent(
    colors: TextFieldConfig,
    value: String,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardActions: () -> Unit,
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= colors.maxChar) {
                onValueChange(it)
            }
        },
        shape = colors.shape,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = colors.imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                keyboardActions()
            }
        ),
        maxLines = colors.maxLines,
        placeholder = {
            if (placeholder != null) {
                placeholder()
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = colors.textFocused,
            unfocusedTextColor = colors.textUnFocused,
            focusedContainerColor = colors.containerFocused,
            unfocusedContainerColor = colors.containerUnFocused,
            cursorColor = colors.cursorColor,
            selectionColors = colors.colorSelectText,
            focusedIndicatorColor = colors.selectedFieldBorder,
            unfocusedIndicatorColor = colors.unSelectedFieldBorder

        ),
        modifier = Modifier
            .height(colors.height)
            .width(colors.width)
        ,
        textStyle = colors.textStyle

    )

}

