package org.compose_projects.socialocal.profile.presentation.components.accountComponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialocal.profile.presentation.ProfileViewModel
import org.compose_projects.socialocal.auth.presentation.states.UsersState
import org.compose_projects.socialocal.core.viewModels.AccountViewModel
import org.compose_projects.socialocal.profile.domain.models.AccountEntity

@Composable
fun SectionAccountsComponent(
    viewModel: ProfileViewModel = hiltViewModel(),
    accountViewModel: AccountViewModel,
    onClick: () -> Unit
) {
    val accounts = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Accounts(
            accounts = accounts,
            accountViewModel = accountViewModel
        ){
            onClick()
        }
    }
}

@Composable
fun Accounts(
    accounts: UsersState,
    accountViewModel: AccountViewModel,
    onClick: () -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.5F),
            verticalArrangement = Arrangement.Top
        ) {
            items(accounts.listUsers) {
                CardShowUsers(
                    account = it.user,
                    accountViewModel
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        CreateAccountComponent(
            title = "Crear cuenta",
            containerColor = MaterialTheme.colorScheme.secondary,
            maxWidth = 0.5F,

            ) {
            onClick()
        }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardShowUsers(account: String, accountViewModel: AccountViewModel) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(0.9F)
            .height(60.dp),
        border = BorderStroke(
            2.dp,
            brush = Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                )
            )
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.7F)
        ), onClick = {
            //Toast.makeText(context, "Hola! $account", Toast.LENGTH_SHORT).show()
            accountViewModel.updateAccount(
                AccountEntity(user = account, id = 1),
            )
        }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = account, style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 2.sp

                )
            )
        }
    }

}