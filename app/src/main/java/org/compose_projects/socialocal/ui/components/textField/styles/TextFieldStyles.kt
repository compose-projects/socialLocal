package org.compose_projects.socialocal.ui.components.textField.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.ui.components.textField.config.TextFieldColors

object TextFieldStyles {

    //estilos claros
    val defaultStyleLight: TextFieldColors
        get() = object :
            TextFieldColors {
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
            override val textStyle: TextStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        }

    //estilos oscuros
    val defaultStyleDark: TextFieldColors
        get() = object :
            TextFieldColors {
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
            override val textStyle: TextStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        }

}