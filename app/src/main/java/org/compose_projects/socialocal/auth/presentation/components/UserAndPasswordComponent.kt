package org.compose_projects.socialocal.auth.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
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
import org.compose_projects.socialocal.ui.components.TextFieldComponent


@Composable
fun UserAndPasswordComponent(
    user: String,
    password: String,
    userValueChange: (String) -> Unit,
    passwordValueChange: (String) -> Unit

) {

    TextFieldComponent(
        value = user,
        maxLines = 1,
        keyboardActions = {
            //todo
        },
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
        maxChar = 15,
        textStyle = TextStyleComponent(
            color = MaterialTheme.colorScheme.background,
            fontSize = 13.sp,
            font = Font(R.font.cabrito),
            fontWight = FontWeight.ExtraBold
        ),
        containerFocused = MaterialTheme.colorScheme.onPrimary,
        textUnFocused = Color.Black
    ) {
        userValueChange(it)
    }

    Spacer(modifier = Modifier.height(15.dp))

    TextFieldComponent(
        value = password,
        maxLines = 1,
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
        containerFocused = MaterialTheme.colorScheme.onPrimary,
        maxChar = 30,
        textStyle = TextStyleComponent(
            color = MaterialTheme.colorScheme.background,
            fontSize = 13.sp,
            font = Font(R.font.cabrito),
            fontWight = FontWeight.ExtraBold
        ),


    ) {
        passwordValueChange(it)
    }
}


