package org.compose_projects.socialocal.ui.components.textField.styles

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import md_theme_dark_onPrimary
import md_theme_dark_onPrimaryContainer
import md_theme_dark_outline
import md_theme_dark_secondaryContainer
import md_theme_dark_shadow
import md_theme_light_onPrimary
import md_theme_light_onPrimaryContainer
import md_theme_light_outline
import md_theme_light_secondaryContainer
import md_theme_light_shadow
import org.compose_projects.socialocal.ui.components.textField.config.TextFieldColors

object TextFieldColors {
    //estilos claros
    val defaultStyleLight: TextFieldColors
        get() = object :
            TextFieldColors {
            override val imeAction: ImeAction = ImeAction.Done
            override val textFocused: Color = md_theme_light_onPrimary
            override val textUnFocused: Color = md_theme_light_onPrimary.copy(alpha = 0.65F)
            override val containerFocused: Color = md_theme_light_secondaryContainer
            override val containerUnFocused: Color = md_theme_light_secondaryContainer.copy(0.65F)
            override val cursorColor: Color = md_theme_light_shadow
            override val colorSelectText: TextSelectionColors =
                TextSelectionColors(
                    handleColor = md_theme_light_onPrimaryContainer,
                    backgroundColor = md_theme_light_onPrimaryContainer.copy(alpha = 0.4f)
                )
            override val selectedFieldBorder: Color = md_theme_light_onPrimary
            override val unSelectedFieldBorder: Color = md_theme_light_outline
            override val textStyle: TextStyle = TextStyle(
                fontSize = 15.sp, //tamaño fuente a la hora de dijitar
                color = Color.White.copy(alpha = 0.85F)
            )
        }

    //estilos oscuros
    val defaultStyleDark: TextFieldColors
        get() = object :
            TextFieldColors {
            override val imeAction: ImeAction = ImeAction.Done
            override val textFocused: Color = md_theme_dark_onPrimary
            override val textUnFocused: Color = md_theme_dark_onPrimary.copy(alpha = 0.65F)
            override val containerFocused: Color = md_theme_dark_secondaryContainer
            override val containerUnFocused: Color = md_theme_dark_secondaryContainer.copy(0.65F)
            override val cursorColor: Color = md_theme_dark_shadow
            override val colorSelectText: TextSelectionColors =
                TextSelectionColors(
                    handleColor = md_theme_dark_onPrimaryContainer,
                    backgroundColor = md_theme_dark_onPrimaryContainer.copy(alpha = 0.4f)
                )
            override val selectedFieldBorder: Color = md_theme_dark_onPrimary
            override val unSelectedFieldBorder: Color = md_theme_dark_outline
            override val textStyle: TextStyle = TextStyle(
                fontSize = 15.sp, //tamaño fuente a la hora de dijitar
                color = Color.White.copy(alpha = 0.85F)
            )
        }

}