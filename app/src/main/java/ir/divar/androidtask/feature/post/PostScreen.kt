package ir.divar.androidtask.feature.post

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ir.divar.androidtask.feature.city.CityItem

@Composable
fun PostScreen(
    navController: NavHostController,
    viewModel: PostViewModel,
    onNavigateToPostDetailsScreen: (WidgetItem) -> Unit
) {
    Surface {
        Text("PostScreen")
    }
}