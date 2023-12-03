package ir.divar.androidtask.data.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PostWithImageItems(
    @Embedded val post: PostEntity,
    @Relation(parentColumn = "uuid", entityColumn = "postId")
    val imageList: List<ImageItemEntity>
)
