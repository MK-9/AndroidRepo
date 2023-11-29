package ir.divar.androidtask.feature.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun CityScreen(
    navController: NavHostController,
    viewModel: CityViewModel,
    onNavigateToPostScreen: (CityItem) -> Unit
) {
    val uiState by viewModel.cityScreenUiState.collectAsState()

    when {
        uiState.isLoading -> {
            ProgressContent()
        }

        uiState.data.isNotEmpty() -> {
            CityScreenContent(uiState.data, onNavigateToPostScreen)
        }
    }
}

@Composable
fun CityScreenContent(data: List<CityItem>, onNavigateToPostScreen: (CityItem) -> Unit) {
    LazyColumn {
        items(items = data) { city ->
            city.title?.run {
                CityScreenItem(city.title) {
                    onNavigateToPostScreen.invoke(city)
                }
            }
        }
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
fun CityScreenItem(title: String, onItemClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onItemClicked.invoke()
            }
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
    }

}