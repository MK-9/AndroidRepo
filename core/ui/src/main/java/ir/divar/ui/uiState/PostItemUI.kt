package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable
import ir.divar.model.PostData

@Immutable
data class PostItemUI(
    val uuid: Long? = 0,
    val cityId: Int?,
    val page: String?,
    val lastPostDate: Long?,
    val widgetType: String?,
    val data: PostData?,
//    val data: PostDataItemUI?,
    val onItemClicked: (() -> Unit)?
) {
    enum class WidgetType(value: String) {
        TITLE_ROW("TITLE_ROW"),
        SUBTITLE_ROW("SUBTITLE_ROW"),
        HEADER_ROW("HEADER_ROW"),
        POST_ROW("POST_ROW"),
        DESCRIPTION_ROW("DESCRIPTION_ROW"),
        INFO_ROW("INFO_ROW"),
        IMAGE_SLIDER_ROW("IMAGE_SLIDER_ROW")
    }
}
