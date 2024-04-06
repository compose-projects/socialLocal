package org.compose_projects.socialocal.auth.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R

@Composable
fun TextStyleComponent(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    fontSize: TextUnit = 18.sp,
    fontWight: FontWeight = FontWeight.Normal,
    font: Font = Font(R.font.cabrito)

): TextStyle
{ return (
        TextStyle(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWight,
            fontFamily = FontFamily(
                font
                )
            )
        )
}