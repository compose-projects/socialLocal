package org.compose_projects.socialocal.ui.components.textField.config

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp

interface TextFieldColors {
    val imeAction: ImeAction
    val textFocused: Color
    val textUnFocused: Color
    val containerFocused: Color
    val containerUnFocused: Color
    val cursorColor: Color
    val colorSelectText: TextSelectionColors
    val selectedFieldBorder: Color
    val unSelectedFieldBorder: Color
    val textStyle: TextStyle
}



/*
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
    )
 */