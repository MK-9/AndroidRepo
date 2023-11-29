package ir.divar.androidtask.feature.post

import ir.divar.androidtask.data.model.dto.ImageItemDto
import ir.divar.androidtask.data.model.dto.WidgetDataDto
import ir.divar.androidtask.data.model.dto.WidgetDto
import ir.divar.androidtask.data.model.response.WidgetsDto

object WidgetMapper {

    fun WidgetsDto.toWidgetsData() =
        WidgetsData(
            widgets = widgets?.map { it.toWidgetItem() },
            lastPostDate = lastPostDate
        )

    private fun WidgetDto.toWidgetItem() =
        WidgetItem(
            widgetType = widgetType,
            data = data?.toWidgetDataItem(),
            null
        )

    private fun WidgetDataDto.toWidgetDataItem() =
        WidgetDataItem(
            title = title,
            subtitle = subtitle,
            text = text,
            value = value,
            token = token,
            price = price,
            city = city,
            district = district,
            imageUrl = imageUrl,
            showThumbnail = showThumbnail,
            thumbnail = thumbnail,
            items = items?.map { it.toImageItem() }
        )

    private fun ImageItemDto.toImageItem() =
        ImageItem(imageUrl = imageUrl)
}