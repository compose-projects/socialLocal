package org.compose_projects.socialocal.auth.presentation.components

import android.content.Context
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.compose_projects.socialocal.auth.R


@Composable
fun ButtonComponent(
    user: String,
    password: String,
    context: Context,
    onClick: (String, String) -> Unit
) {

    OutlinedButton(onClick = {
        onClick(user, password)
    }) {
        Text(
            text = stringResource(id = R.string.register),
            style = TextStyleComponent()
        )
    }
}