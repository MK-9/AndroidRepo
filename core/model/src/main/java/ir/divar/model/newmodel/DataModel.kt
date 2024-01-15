package ir.divar.model.newmodel

data class DataModel(
    val token: String?,
    val title: String?,
    val subtitle: String?,
    val text: String?,
    val value: String?,
    val price: String?,
    val city: String?,
    val district: String?,
    val imageUrl: String?,
    val showThumbnail: Boolean = false,
    val thumbnail: String?,
    val items: List<ImageItemModel>?
)