package ir.divar.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.divar.ui.screen.DescriptionRowItem
import ir.divar.ui.screen.HeaderRowItem
import ir.divar.ui.screen.ImageSliderRowItem
import ir.divar.ui.screen.InfoRowItem
import ir.divar.ui.screen.PostRowItem
import ir.divar.ui.screen.SubtitleRowItem
import ir.divar.ui.screen.TitleRowItem
import ir.divar.ui.uiState.PostItemExtension.isDescriptionRow
import ir.divar.ui.uiState.PostItemExtension.isHeaderRow
import ir.divar.ui.uiState.PostItemExtension.isImageSliderRow
import ir.divar.ui.uiState.PostItemExtension.isInfoRow
import ir.divar.ui.uiState.PostItemExtension.isPostRow
import ir.divar.ui.uiState.PostItemExtension.isSubtitleRow
import ir.divar.ui.uiState.PostItemExtension.isTitleRow
import ir.divar.ui.uiState.PostItemUI

@Composable
fun PostScreenContent(
    data: List<PostItemUI>?,
    onItemClicked: (PostItemUI) -> Unit,
    state: PlaceHolderState,
    loadMore: () -> Unit,
    onRetry: () -> Unit
) {
    val widgets = data ?: arrayListOf()
    EndlessColumn(
        widgets = widgets,
        state = state,
        onItemClicked = onItemClicked,
        loadMore = loadMore,
        onRetry = onRetry
    )
}

@Composable
fun EndlessColumn(
    widgets: List<PostItemUI> = arrayListOf(),
    state: PlaceHolderState,
    onItemClicked: (PostItemUI) -> Unit,
    loadMore: () -> Unit,
    onRetry: () -> Unit
) {
    val threshold = 0
    val lastIndex = widgets.lastIndex

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(4.dp)
    ) {
        items(count = widgets.size + 1, key = { widgets.getOrNull(it)?.uuid ?: 0 }) { index ->

            val widget = widgets.getOrNull(index)
            val parentMaxWidth = Modifier.fillParentMaxWidth()

            widget?.run {

                if (index + threshold >= lastIndex && state !is PlaceHolderState.Loading) {
                    SideEffect {
                        loadMore()
                    }
                }

                when {
                    isImageSliderRow() -> {
                        ImageSliderRowItem(this)
                    }

                    isHeaderRow() -> {
                        HeaderRowItem(this.data)
                    }

                    isTitleRow() -> {
                        TitleRowItem(this)
                    }

                    isSubtitleRow() -> {
                        SubtitleRowItem(this)
                    }

                    isDescriptionRow() -> {
                        DescriptionRowItem(this)
                    }

                    isInfoRow() -> {
                        InfoRowItem(this.data)
                    }

                    isPostRow() -> {
                        PostRowItem(widget, onItemClicked)
                    }
                }

                return@items
            }

            when (state) {
                is PlaceHolderState.Failure -> FailureItem(
                    throwable = state.throwable,
                    onRetry = onRetry,
                    modifier = parentMaxWidth,
                )

                is PlaceHolderState.Idle -> if (!state.isEmpty) {
                    Spacer(modifier = parentMaxWidth.requiredHeight(48.dp))
                }

                PlaceHolderState.Loading -> LoadingItem(modifier = parentMaxWidth)
            }
        }
    }
}

@Composable
fun LoadingItem(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(18.dp)
                .height(18.dp),
            color = Color.LightGray,
            strokeWidth = 1.dp,
            trackColor = Color.White,
            strokeCap = StrokeCap.Square
        )
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
