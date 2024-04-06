package org.compose_projects.socialocal.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(title: String) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.cocogoose_pro_letterpress_regular_trial)),
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer),
        modifier = Modifier
            .height(58.dp), // Puede que necesites ajustar esta altura según tus necesidades.
    )
}
