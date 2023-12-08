package ir.divar.androidtask.feature.generic.uiState

object PostItemExtension {
    fun PostItemUI.isHeaderRow() = widgetType == PostItemUI.WidgetType.HEADER_ROW.name
    fun PostItemUI.isPostRow() = widgetType == PostItemUI.WidgetType.POST_ROW.name
    fun PostItemUI.isTitleRow() = widgetType == PostItemUI.WidgetType.TITLE_ROW.name
    fun PostItemUI.isSubtitleRow() = widgetType == PostItemUI.WidgetType.SUBTITLE_ROW.name
    fun PostItemUI.isDescriptionRow() = widgetType == PostItemUI.WidgetType.DESCRIPTION_ROW.name
    fun PostItemUI.isInfoRow() = widgetType == PostItemUI.WidgetType.INFO_ROW.name
    fun PostItemUI.isImageSliderRow() = widgetType == PostItemUI.WidgetType.IMAGE_SLIDER_ROW.name
}