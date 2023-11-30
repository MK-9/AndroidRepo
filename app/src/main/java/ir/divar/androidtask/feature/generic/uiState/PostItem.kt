package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostItem(
    val widgetType: String?, val data: PostDataItem?, val onItemClicked: (() -> Unit)?
) {
    enum class WidgetType(value: String) {
        TITLE_ROW("TITLE_ROW"), SUBTITLE_ROW("SUBTITLE_ROW"), HEADER_ROW("HEADER_ROW"), POST_ROW("POST_ROW")
    }
}
