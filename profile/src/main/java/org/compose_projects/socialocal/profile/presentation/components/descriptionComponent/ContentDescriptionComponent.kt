package org.compose_projects.socialocal.profile.presentation.components.descriptionComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.core.R

@Composable
fun ContentDescriptionComponent(description: String, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Text(text = if (description == "") stringResource(id = R.string.description_default) else description,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 11.5.sp
            ),
            modifier = Modifier.clickable {
                onClick()
            })
    }
}