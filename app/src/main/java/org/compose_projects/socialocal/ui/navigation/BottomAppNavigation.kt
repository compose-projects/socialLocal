package org.compose_projects.socialocal.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BottomAppNavigation(navController: NavHostController) {
    BottomAppBar(
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        modifier = Modifier
            .height(58.dp),
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        // Itera sobre los elementos del menú
        Screens.items.forEach { item ->
            Spacer(
                Modifier.weight(
                    0.1f,
                    true
                )
            ) // Ajusta el Modifier.weight para una mejor distribución

            IconButton(onClick = { navController.navigate(item.route) }) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(
                        item.icon,
                        contentDescription = item.contentDescription,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(text = item.name, style = TextStyle(
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    ))
                }
            }

            Spacer(
                Modifier.weight(
                    0.1f,
                    true
                )
            )
        }
    }
}
