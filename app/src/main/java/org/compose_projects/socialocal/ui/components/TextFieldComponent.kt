package org.compose_projects.socialocal.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.auth.presentation.components.TextStyleComponent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldComponent(
    value: String,
    maxLines: Int,
    imeAction: ImeAction = ImeAction.Done,
    textFocused: Color = MaterialTheme.colorScheme.background,
    textUnFocused: Color = Color.White,
    containerFocused: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    containerUnFocused: Color = Color.Gray,
    cursorColor: Color = Color.White,
    colorSelectText: TextSelectionColors = TextSelectionColors(
        handleColor = Color.Blue,
        backgroundColor = Color.Red.copy(alpha = 0.4f)
    ),
    selectedFieldBorder: Color = Color.White,
    unSelectedFieldBorder: Color = Color.Black.copy(alpha = 0.7F),
    height: Dp = 50.dp,
    width: Dp = 250.dp,
    maxChar: Int = 35,
    shape: RoundedCornerShape = RoundedCornerShape(40.dp),
    textStyle: TextStyle = TextStyleComponent(
        font = Font(R.font.cocogoose_pro_italic_trial),
        fontSize = 13.sp,
        color = Color.White,
        fontWight = FontWeight.Light
    ),
    placeholder: @Composable (() -> Unit)? = null,
    keyboardActions: () -> Unit,
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= maxChar) {
                onValueChange(it)
            }
        },
        shape = shape,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                keyboardActions()
            }
        ),
        maxLines = maxLines,
        placeholder = {
            if (placeholder != null) {
                placeholder()
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = textFocused,
            unfocusedTextColor = textUnFocused,
            focusedContainerColor = containerFocused,
            unfocusedContainerColor = containerUnFocused,
            cursorColor = cursorColor,
            selectionColors = colorSelectText,
            focusedIndicatorColor = selectedFieldBorder,
            unfocusedIndicatorColor = unSelectedFieldBorder

        ),
        modifier = Modifier
            .height(height)
            .width(width)
        ,
        textStyle = textStyle

    )

}