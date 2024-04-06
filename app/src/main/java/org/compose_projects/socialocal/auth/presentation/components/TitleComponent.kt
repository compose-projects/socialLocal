package org.compose_projects.socialocal.auth.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R

@Composable
fun TitleComponent(title: Int) {
    Text(text = stringResource(id = title),
        style = TextStyleComponent(
            font = Font(R.font.cocogoose_pro_letterpress_regular_trial),
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWight = FontWeight.SemiBold
        )
    )
}