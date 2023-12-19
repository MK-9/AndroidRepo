package ir.divar.postdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun PostDetailsScreen(
    navController: NavHostController, viewModel: PostDetailsViewModel = hiltViewModel()
) {

    val postDetailsUiState by viewModel.postDetailsUiState.collectAsState()

    if (postDetailsUiState.isLoading) {
        ir.divar.ui.ProgressContent()
    } else if (postDetailsUiState.data == null || postDetailsUiState.data?.widgets == null || postDetailsUiState.data?.widgets?.size == 0) {
        ir.divar.ui.ProgressContent()
    } else if (postDetailsUiState.data?.widgets!!.isNotEmpty()) {
        PostScreenDetailsContent(postDetailsUiState.data)
    }
}