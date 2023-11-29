package ir.divar.androidtask.feature.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.divar.androidtask.R

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
private fun CityScreenContent(data: List<CityItem>, onNavigateToPostScreen: (CityItem) -> Unit) {
    LazyColumn {
        item {
            HeaderContent()
        }

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
private fun HeaderContent() {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = stringResource(R.string.selectCity),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun ProgressContent() {
    Surface(color = Color.Gray) {
        Box {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun CityScreenItem(title: String, onItemClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
        
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onItemClicked.invoke()
                }
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}