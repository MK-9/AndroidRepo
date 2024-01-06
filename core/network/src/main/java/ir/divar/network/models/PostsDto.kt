package ir.divar.network.models

import com.google.gson.annotations.SerializedName

data class PostsDto(
    @SerializedName("widget_list") val widgets: List<PostDto>?,
    @SerializedName("last_post_date") val lastPostDate: Long?
)
