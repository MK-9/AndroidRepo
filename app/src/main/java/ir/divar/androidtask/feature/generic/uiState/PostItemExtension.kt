package ir.divar.androidtask.feature.generic.uiState

object PostItemExtension {
    fun PostItem.isHeaderRow() = widgetType == PostItem.WidgetType.HEADER_ROW.name
    fun PostItem.isPostRow() = widgetType == PostItem.WidgetType.POST_ROW.name
    fun PostItem.isTitleRow() = widgetType == PostItem.WidgetType.TITLE_ROW.name
    fun PostItem.isSubtitleRow() = widgetType == PostItem.WidgetType.SUBTITLE_ROW.name
    fun PostItem.isDescriptionRow() = widgetType == PostItem.WidgetType.DESCRIPTION_ROW.name
    fun PostItem.isInfoRow() = widgetType == PostItem.WidgetType.INFO_ROW.name
    fun PostItem.isImageSliderRow() = widgetType == PostItem.WidgetType.IMAGE_SLIDER_ROW.name
}