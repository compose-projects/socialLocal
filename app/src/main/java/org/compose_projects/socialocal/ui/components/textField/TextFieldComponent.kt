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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.compose_projects.socialocal.ui.components.textField.config.TextFieldColors
import org.compose_projects.socialocal.ui.components.textField.config.TextFieldSizes
import org.compose_projects.socialocal.ui.components.textField.styles.SLTextFieldColors
import org.compose_projects.socialocal.ui.components.textField.styles.SLTextFieldSizes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SLTextField(
    colors: TextFieldColors = SLTextFieldColors.defaultStyleDark,
    sizes: TextFieldSizes = SLTextFieldSizes.defaultSize,
    value: String,
    showText: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardActions: (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= sizes.maxChar) {
                onValueChange(it)
            }
        },
        shape = sizes.shape,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = colors.imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                if (keyboardActions != null){
                    keyboardActions()
                }
            }
        ),
        maxLines = sizes.maxLines,
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
        visualTransformation = if (showText) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if (trailingIcon != null) {
                trailingIcon()
            }
        },
        modifier = Modifier
            .height(sizes.height)
            .width(sizes.width),
        textStyle = colors.textStyle
    )

}

