package ir.divar.androidtask.data.model.external

data class PostDetails(
    val widgets: List<Post>?,
    val enableContact: Boolean,
    val contactButtonText: String?
)
