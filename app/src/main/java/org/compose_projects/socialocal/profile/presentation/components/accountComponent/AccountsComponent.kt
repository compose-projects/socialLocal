package org.compose_projects.socialocal.profile.presentation.components.accountComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import org.compose_projects.socialocal.common.viewModels.AccountViewModel
import org.compose_projects.socialocal.profile.domain.models.Account
import org.compose_projects.socialocal.profile.presentation.components.SheetsComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsComponent(
    accountViewModel: AccountViewModel,
    scope: CoroutineScope,
    sheetState: SheetState,
    content: @Composable () -> Unit
) {
    var showBottomSheet by remember { mutableStateOf(false) }


    val account = accountViewModel.state.listUsers


    Row(modifier = Modifier.clickable {
        showBottomSheet = true
    }
    ) {

        NameAccount(account = account)

        Spacer(modifier = Modifier.width(10.dp))

        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }

    Divider(modifier = Modifier.width(100.dp), color = MaterialTheme.colorScheme.primary)
    SheetsComponent(
        scope = scope,
        showBottomSheet = showBottomSheet,
        sheetState = sheetState,
        onDissRequests = {
            showBottomSheet = false
        },

        content = {
            content()
        }

    )
}


@Composable
fun NameAccount(account: List<Account>) {
    Text(
        text = account[0].user, style = TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = 15.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold
        )
    )
}