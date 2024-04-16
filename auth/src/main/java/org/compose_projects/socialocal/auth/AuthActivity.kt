package org.compose_projects.socialocal.auth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.android.AndroidEntryPoint
import org.compose_projects.socialocal.auth.presentation.LoginScreen
import org.compose_projects.socialocal.auth.ui.theme.SocialLocalTheme


@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthScreen()
        }
    }
}


@Composable
fun AuthScreen() {

    val context = LocalContext.current
    SocialLocalTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold {
                LoginScreen(
                    paddingValues = it
                ){
                    Toast.makeText(context, "Nuevo usuario! $it", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
