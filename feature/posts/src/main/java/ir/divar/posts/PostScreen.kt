package ir.divar.posts

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.divar.androidtask.feature.generic.screen.PostScreenContent
import ir.divar.androidtask.feature.generic.uiState.PostItemUI

@Composable
fun PostScreen(
    navController: NavHostController,
    viewModel: PostViewModel = hiltViewModel(),
    onNavigateToPostDetailsScreen: (PostItemUI) -> Unit
) {
    val widgetsUiState by viewModel.postsUiState.collectAsState()
    val loadingState by viewModel.loadingStateFlow.collectAsState()

    if (widgetsUiState.isLoading) {
        ir.divar.ui.ProgressContent()
    } else if (widgetsUiState.data == null || widgetsUiState.data?.size == 0) {
        ir.divar.ui.ProgressContent()
    } else if (widgetsUiState.data?.isNotEmpty() == true) {
        PostScreenContent(
            widgetsUiState.data,
            onNavigateToPostDetailsScreen,
            state = loadingState,
            loadMore = viewModel::loadNextPage,
            onRetry = {}
        )
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