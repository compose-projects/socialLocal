package org.compose_projects.socialocal.profile.presentation.components.accountComponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountComponent(
    title: String,
    containerColor: Color = MaterialTheme.colorScheme.background.copy(alpha = 0.7F),
    bordeColor1: Color = MaterialTheme.colorScheme.primary,
    borderColor2: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = MaterialTheme.colorScheme.background,
    maxWidth: Float = 0.9F,
    height: Dp = 60.dp,
    onClick: () -> Unit
) {

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(maxWidth)
            .height(height)
            ,
        border = BorderStroke(
            2.dp,
            brush = Brush.linearGradient(
                listOf(
                    bordeColor1,
                    borderColor2
                )
            )
        ),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        onClick = { onClick() }) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    color = textColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.skate_board_unlimited)),
                    letterSpacing = 2.sp
                )
            )

        }
    }
}