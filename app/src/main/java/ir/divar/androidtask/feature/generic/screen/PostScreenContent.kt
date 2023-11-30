package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ir.divar.androidtask.feature.generic.uiState.PostItem
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isDescriptionRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isHeaderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isImageSliderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isInfoRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isPostRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isSubtitleRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isTitleRow
import ir.divar.androidtask.feature.generic.uiState.PostsData

@Composable
fun PostScreenContent(data: PostsData?, onItemClicked: (PostItem) -> Unit) {
    val widgets = data?.widgets ?: arrayListOf()

    LazyColumn {
        items(items = widgets) { widgetItem ->
            when {
                widgetItem.isImageSliderRow() -> {
                    ImageRowItem(widgetItem)
                }

                widgetItem.isHeaderRow() -> {
                    HeaderRowItem(widgetItem)
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
                    InfoRowItem(widgetItem)
                }

                widgetItem.isPostRow() -> {
                    PostRowItem(widgetItem, onItemClicked)
                }

                widgetItem.isImageSliderRow() -> {
                    ImageRowItem(widgetItem)
                }
            }
        }
    }
}