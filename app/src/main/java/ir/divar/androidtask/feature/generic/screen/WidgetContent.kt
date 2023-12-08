package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import ir.divar.androidtask.feature.generic.uiState.PostItemUI
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isDescriptionRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isHeaderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isImageSliderRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isInfoRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isPostRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isSubtitleRow
import ir.divar.androidtask.feature.generic.uiState.PostItemExtension.isTitleRow

fun LazyListScope.WidgetContent(widgets: List<PostItemUI>, onItemClicked: ((PostItemUI) -> Unit)? = null) {
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