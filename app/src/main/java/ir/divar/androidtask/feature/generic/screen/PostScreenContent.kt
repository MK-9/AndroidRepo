package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isDescriptionRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isHeaderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isImageSliderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isInfoRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isPostRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isSubtitleRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isTitleRow
import ir.divar.androidtask.feature.generic.uiState.PostItemUI
import ir.divar.androidtask.feature.post.PlaceHolderState

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
        loadMore = loadMore,
        onRetry = onRetry
    )
}

@Composable
fun EndlessColumn(
    widgets: List<PostItemUI> = arrayListOf(),
    state: PlaceHolderState,
    loadMore: () -> Unit,
    onRetry: () -> Unit
) {
    val threshold = 0
    val lastIndex = widgets.lastIndex

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(count = widgets.size + 1, key = { widgets.getOrNull(it)?.uuid ?: 0 }) { index ->

            val widget = widgets.getOrNull(index)
            val parentMaxWidth = Modifier.fillParentMaxWidth()

            widget?.run {

                when (state) {
                    is PlaceHolderState.Failure -> {
//                        Log.d("######", "state: Failure")
                    }

                    is PlaceHolderState.Idle -> {
//                        Log.d("######", "LazyColumn state: Idle")
                    }

                    PlaceHolderState.Loading -> {
//                        Log.d("######", "LazyColumn state: Loading")
                    }
                }

//                Log.d("######", "index: $index")
//                Log.d("######", "lastIndex: $lastIndex")
                if (index + threshold >= lastIndex && state !is PlaceHolderState.Loading){
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
                        PostRowItem(widget, null)
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
        modifier = Modifier.fillMaxWidth(),
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
