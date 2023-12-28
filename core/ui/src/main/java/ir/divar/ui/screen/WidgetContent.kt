package ir.divar.ui.screen

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import ir.divar.ui.uiState.PostItemUI
import ir.divar.ui.uiState.PostItemExtension.isDescriptionRow
import ir.divar.ui.uiState.PostItemExtension.isHeaderRow
import ir.divar.ui.uiState.PostItemExtension.isImageSliderRow
import ir.divar.ui.uiState.PostItemExtension.isInfoRow
import ir.divar.ui.uiState.PostItemExtension.isPostRow
import ir.divar.ui.uiState.PostItemExtension.isSubtitleRow
import ir.divar.ui.uiState.PostItemExtension.isTitleRow

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