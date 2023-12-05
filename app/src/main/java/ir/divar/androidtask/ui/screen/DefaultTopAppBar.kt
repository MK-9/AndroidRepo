package ir.divar.androidtask.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.divar.androidtask.ui.theme.Purple40
import ir.divar.androidtask.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar() {
    TopAppBar(
        title = { Text(text = "Home") },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack"
            )
        },
        actions = {
        },
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Purple80,
            scrolledContainerColor = Purple80,
            navigationIconContentColor = Purple40,
            titleContentColor = Purple40,
            actionIconContentColor = Purple40
        ),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}