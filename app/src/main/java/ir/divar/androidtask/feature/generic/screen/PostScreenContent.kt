package ir.divar.androidtask.feature.generic.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.divar.androidtask.feature.generic.uiState.PostItemUI
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isDescriptionRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isHeaderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isImageSliderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isInfoRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isPostRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isSubtitleRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isTitleRow
import ir.divar.androidtask.feature.generic.uiState.PostsDataUI

@Composable
fun PostScreenContent(data: PostsDataUI?, onItemClicked: (PostItemUI) -> Unit) {
    val widgets = data?.widgets ?: arrayListOf()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(items = widgets) { widgetItem ->
            when {
                widgetItem.isImageSliderRow() -> {
                    ImageSliderRowItem(widgetItem)
                }

                widgetItem.isHeaderRow() -> {
                    HeaderRowItem(widgetItem.data)
                }

                widgetItem.isTitleRow() -> {
                    TitleRowItem(widgetItem)
                }

                widgetItem.isSubtitleRow() -> {
                    SubtitleRowItem(widgetItem)
                }

                widgetItem.isDescriptionRow() -> {
                    DescriptionRowItem(widgetItem)
                }

                widgetItem.isInfoRow() -> {
                    InfoRowItem(widgetItem.data)
                }

                widgetItem.isPostRow() -> {
                    PostRowItem(widgetItem, onItemClicked)
                }
            }
        }
    }
}

@Composable
fun EndlessColumn(widgets: List<PostItemUI> = arrayListOf(), loadMore: () -> Unit) {
    val threshold = 3
    val lastIndex = widgets.lastIndex

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(8.dp)
    ) {
//        items(count = widgets.size + 1, key = { widgets.getOrNull(it)?.id ?: 0 }) { index ->
        items(count = widgets.size + 1 ) { index ->

            val widget = widgets.getOrNull(index)
            widget?.run {

                if (index + threshold >= lastIndex) {
                    SideEffect {
                        Log.d("######", "lastIndex: $lastIndex")
                        loadMore()
                    }
                }

                when {
                    widget.isImageSliderRow() -> {
                        ImageSliderRowItem(widget)
                    }

                    widget.isHeaderRow() -> {
                        HeaderRowItem(widget.data)
                    }

                    widget.isTitleRow() -> {
                        TitleRowItem(widget)
                    }

                    widget.isSubtitleRow() -> {
                        SubtitleRowItem(widget)
                    }

                    widget.isDescriptionRow() -> {
                        DescriptionRowItem(widget)
                    }

                    widget.isInfoRow() -> {
                        InfoRowItem(widget.data)
                    }

                    widget.isPostRow() -> {
                        PostRowItem(widget, null)
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingItem(modifier: Modifier) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun FailureItem(throwable: Throwable, onRetry: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = throwable.message ?: "", maxLines = 2, overflow = TextOverflow.Ellipsis)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onRetry() }) {
            Text(text = "Retry")
        }
    }
}
