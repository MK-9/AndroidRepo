package ir.divar.network.models

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.network.models.PostDto

data class PostsDto(
    @SerializedName("widget_list") val widgets: List<PostDto>?,
    @SerializedName("last_post_date") val lastPostDate: Long?
)
