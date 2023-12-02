package ir.divar.androidtask.feature.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.divar.androidtask.feature.generic.screen.PostScreenContent
import ir.divar.androidtask.feature.generic.uiState.PostItem

@Composable
fun PostScreen(
    navController: NavHostController,
    viewModel: PostViewModel = hiltViewModel(),
    onNavigateToPostDetailsScreen: (PostItem) -> Unit
) {
    val widgetsUiState by viewModel.postsUiState.collectAsState()

    if (widgetsUiState.isLoading) {
        ProgressContent()
    } else if (widgetsUiState.data == null || widgetsUiState.data?.widgets == null || widgetsUiState.data?.widgets?.size == 0) {
        NoDataContent()
    } else if (widgetsUiState.data?.widgets!!.isNotEmpty()) {
        PostScreenContent(widgetsUiState.data, onNavigateToPostDetailsScreen)
    }
}

@Composable
fun ProgressContent() {
    Surface(color = Color.Gray) {
        Box {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun NoDataContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("NoData!")
    }
}