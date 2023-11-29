package ir.divar.androidtask.feature.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.memory.MemoryCache
import coil.request.ImageRequest

@Composable
fun PostScreen(
    navController: NavHostController,
    viewModel: PostViewModel,
    onNavigateToPostDetailsScreen: (WidgetItem) -> Unit
) {
    val widgetsUiState by viewModel.widgetScreenUiState.collectAsState()

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

@Composable
fun PostScreenContent(data: WidgetsData?, onItemClicked: (WidgetItem) -> Unit) {
    val widgets = data?.widgets ?: arrayListOf()

    LazyColumn {
        items(items = widgets) { widgetItem ->
            when {
                widgetItem.widgetType == WidgetItem.WidgetType.TITLE_ROW.name -> {
                    TitleRowItem(widgetItem)
                }

                widgetItem.widgetType == WidgetItem.WidgetType.SUBTITLE_ROW.name -> {
                    SubtitleRowItem(widgetItem)
                }

                widgetItem.widgetType == WidgetItem.WidgetType.POST_ROW.name -> {
                    PostRowItem(widgetItem, onItemClicked)
                }
            }
        }
    }
}

@Composable
fun TitleRowItem(widget: WidgetItem) {
    Row {
        Text(
            text = widget.data?.text ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
fun SubtitleRowItem(widget: WidgetItem) {
    Row {
        Text(
            text = widget.data?.text ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostRowItem(widget: WidgetItem, onItemClicked: (WidgetItem) -> Unit) {
    ElevatedCard(
        onClick = { onItemClicked.invoke(widget) }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {


            // Intentionally not a state object to avoid recomposition.
            var placeholder: MemoryCache.Key? = null

            //thumbnail
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(widget.data?.thumbnail)
//                    .placeholderMemoryCacheKey()
                    .build(),
                contentDescription = "widget",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                onSuccess = { placeholder = it.result.memoryCacheKey },
                onError = { ColorPainter(Color.Red) },
                contentScale = ContentScale.FillWidth,
                placeholder = ColorPainter(Color.Gray)
            )

            //title
            Text(
                text = widget.data?.title ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
            )

            //district
            widget.data?.district?.run {
                Text(
                    text = widget.data.district,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }

            //price
            widget.data?.price?.run {
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = widget.data.price,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = 16.dp
                        ),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}