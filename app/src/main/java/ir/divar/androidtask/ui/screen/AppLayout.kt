package ir.divar.androidtask.ui.screen

import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MainLayout() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier,
        topBar = {
            DefaultTopAppBar()
        },
        bottomBar = {
        },
        snackbarHost = {},
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = contentColorFor(MaterialTheme.colorScheme.background),
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets
    ) { paddingValues ->
        DefaultContent(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}