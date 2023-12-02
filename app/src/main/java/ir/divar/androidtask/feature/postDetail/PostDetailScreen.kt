package ir.divar.androidtask.feature.postDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import ir.divar.androidtask.feature.generic.screen.PostScreenDetailsContent

@Composable
fun PostDetailsScreen(
    navController: NavHostController,
    viewModel: PostDetailsViewModel
) {

    val postDetailsUiState by viewModel.postDetailsUiState.collectAsState()

    if (postDetailsUiState.isLoading) {

    } else if (postDetailsUiState.data == null || postDetailsUiState.data?.widgets == null || postDetailsUiState.data?.widgets?.size == 0) {

    } else if (postDetailsUiState.data?.widgets!!.isNotEmpty()) {
        PostScreenDetailsContent(postDetailsUiState.data)
    }
}