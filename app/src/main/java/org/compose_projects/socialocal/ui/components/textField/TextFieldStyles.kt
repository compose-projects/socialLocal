package org.compose_projects.socialocal.ui.components.textField

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object TextFieldStyles {

    //estilos claros
    val defaultStyleLight: TextFieldConfig
        get() = object : TextFieldConfig {
            override val maxLines: Int = 1
            override val imeAction: ImeAction = ImeAction.Done
            override val textFocused: Color = Color.Black
            override val textUnFocused: Color = Color.Gray
            override val containerFocused: Color = Color.Red
            override val containerUnFocused: Color = Color.Gray
            override val cursorColor: Color = Color.Black
            override val colorSelectText: TextSelectionColors =
                TextSelectionColors(
                    handleColor = Color.Blue,
                    backgroundColor = Color.Red.copy(alpha = 0.4f)
                )
            override val selectedFieldBorder: Color = Color.Blue
            override val unSelectedFieldBorder: Color = Color.Gray
            override val height: Dp = 56.dp
            override val width: Dp = 250.dp
            override val maxChar: Int = 35
            override val shape: RoundedCornerShape = RoundedCornerShape(8.dp)
            override val textStyle: TextStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        }

    //estilos oscuros
    val defaultStyleDark: TextFieldConfig
        get() = object : TextFieldConfig {
            override val maxLines: Int = 1
            override val imeAction: ImeAction = ImeAction.Done
            override val textFocused: Color = Color.Black
            override val textUnFocused: Color = Color.Gray
            override val containerFocused: Color = Color.Blue
            override val containerUnFocused: Color = Color.Gray
            override val cursorColor: Color = Color.Black
            override val colorSelectText: TextSelectionColors = TextSelectionColors(
                handleColor = Color.Blue,
                backgroundColor = Color.Red.copy(alpha = 0.4f)
            )
            override val selectedFieldBorder: Color = Color.Blue
            override val unSelectedFieldBorder: Color = Color.Gray
            override val height: Dp = 56.dp
            override val width: Dp = 250.dp
            override val maxChar: Int = 35
            override val shape: RoundedCornerShape = RoundedCornerShape(8.dp)
            override val textStyle: TextStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        }

}