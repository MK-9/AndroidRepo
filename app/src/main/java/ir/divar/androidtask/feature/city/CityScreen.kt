package ir.divar.androidtask.feature.city

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.divar.androidtask.R

@Composable
fun CityScreen(
    navController: NavHostController,
    viewModel: CityViewModel = hiltViewModel(),
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
                CityScreenItem(this) {
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
            style = MaterialTheme.typography.titleMedium
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CityScreenItem(title: String, onItemClicked: () -> Unit) {
    ElevatedCard(
        onClick = { onItemClicked.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        colors = CardDefaults.elevatedCardColors()
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}