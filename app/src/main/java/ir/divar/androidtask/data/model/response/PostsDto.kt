package ir.divar.androidtask.data.model.response

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.PostDto

data class PostsDto(
    @SerializedName("widget_list") val widgets: List<PostDto>?,
    @SerializedName("last_post_date") val lastPostDate: String?
)
