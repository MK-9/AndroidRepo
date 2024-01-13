package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postDetails")
data class PostDetails(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val widgets: List<PostDetailsWidget>?,
    val enableContact: Boolean,
    val contactButtonText: String?
)
