package org.compose_projects.socialocal.auth.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.core.R

@Composable
fun LogoAppComponent(top: Dp) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = top, start = 15.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(70.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,

                    )
            }

            Text(
                text = stringResource(id = R.string.app_name),
                style = TextStyleComponent(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontSize = 13.sp,
                    font = Font(R.font.skate_board_unlimited)
                )
            )

        }

    }

}