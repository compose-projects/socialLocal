package org.compose_projects.socialocal.auth.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialocal.R
import org.compose_projects.socialocal.ui.components.textField.TextFieldComponent
import org.compose_projects.socialocal.ui.components.textField.styles.TextFieldSizes
import org.compose_projects.socialocal.ui.components.textField.styles.TextFieldStyles


@Composable
fun UserAndPasswordComponent(
    user: String,
    password: String,
    userValueChange: (String) -> Unit,
    passwordValueChange: (String) -> Unit

) {

    TextFieldComponent(
        colors = TextFieldStyles.defaultStyleLight,
        sizes = TextFieldSizes.defaultSize,
        keyboardActions = {
            //todo
        },
        value = user,
        placeholder = {
            Text(
                text = stringResource(id = R.string.user_es),
                style = TextStyleComponent(
                    color = Color.Black,
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

    TextFieldComponent(
        colors = TextFieldStyles.defaultStyleDark,
        sizes = TextFieldSizes.defaultSize,
        value = password,
        keyboardActions = {
            //todo
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.password_es),
                style = TextStyleComponent(
                    color = Color.Black,
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


