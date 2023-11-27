package ir.divar.androidtask.data.model.response

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.WidgetDto

data class PostListDto(
    @SerializedName("widget_list") val widgets: List<WidgetDto>?,
    @SerializedName("last_post_date") val lastPostDate: String?
)
