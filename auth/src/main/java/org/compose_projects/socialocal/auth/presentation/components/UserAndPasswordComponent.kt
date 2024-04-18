package org.compose_projects.socialocal.auth.presentation.components


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.auth.R
import org.compose_projects.socialocal.auth.ui.components.textField.SLTextField
import org.compose_projects.socialocal.auth.ui.components.textField.styles.SLTextFieldColors
import org.compose_projects.socialocal.auth.ui.components.textField.styles.SLTextFieldSizes

@Composable
fun UserAndPasswordComponent(
    user: String,
    password: String,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    onClick: () -> Unit,
    userValueChange: (String) -> Unit,
    passwordValueChange: (String) -> Unit

) {
    var showText by remember { mutableStateOf(false) }

    SLTextField(
        colors = if (!useDarkTheme) SLTextFieldColors.defaultStyleLight else SLTextFieldColors.defaultStyleDark,
        sizes = SLTextFieldSizes.defaultSize,
        keyboardActions = {
            //todo
        },
        value = user,
        showText = true,
        trailingIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = null,
                    tint = Color.White.copy(0.9F)
                )
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.user),
                style = TextStyleComponent(
                    color = Color.White.copy(alpha = 0.6F),
                    fontWight = FontWeight.Light,
                    font = Font(R.font.cocogoose_pro_italic_trial),
                    fontSize = 13.sp
                )
            )
        },
    ) {
        userValueChange(it)
    }

    Spacer(modifier = Modifier.height(15.dp))

    SLTextField(
        colors = if (!useDarkTheme) SLTextFieldColors.defaultStyleLight else SLTextFieldColors.defaultStyleDark,
        sizes = SLTextFieldSizes.defaultSize,
        value = password,
        keyboardActions = {
            //todo
        },
        trailingIcon = {
            IconButton(onClick = { showText = !showText }) {
                if (!showText) {
                    Icon(
                        painter = painterResource(id = R.drawable.visibility_off_ic),
                        contentDescription = null,
                        tint = Color.White.copy(0.9F)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.visibility_on_ic),
                        contentDescription = null,
                        tint = Color.White.copy(0.9F)
                    )

                }

            }
        },
        showText = showText,
        placeholder = {
            Text(
                text = stringResource(id = R.string.password),
                style = TextStyleComponent(
                    color = Color.White.copy(alpha = 0.6F),
                    fontWight = FontWeight.Light,
                    font = Font(R.font.cocogoose_pro_italic_trial),
                    fontSize = 13.sp
                )
            )
        },

        ) {
        passwordValueChange(it)
    }
}


