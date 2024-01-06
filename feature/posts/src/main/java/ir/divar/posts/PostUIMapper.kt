package ir.divar.posts


object PostUIMapper {

    fun PostDetailsDto.toPostDetailsData() = PostDetailsDataUI(
        widgets = widgets?.map { it.toPostItem() },
        enableContact = enableContact,
        contactButtonText = contactButtonText
    )

    fun PostsDto.toPostsData() = PostsDataUI(
        widgets = widgets?.map { it.toPostItem() }
    )

    private fun PostDto.toPostItem() = PostItemUI(
        uuid = 0,
        cityId = 0,
        page = "",
        lastPostDate = 0,
        widgetType = widgetType,
        data = data?.toPostDataItem(),
        null
    )

    private fun PostDataDto.toPostDataItem() = PostDataItemUI(title = title,
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
        items = items?.map { it.toImageItem() })

    private fun ImageItemDto.toImageItem() = ImageItemUI(imageUrl = imageUrl)


    ////////// Post External Model -------> UI Model //////////
    fun Posts.toPostsItemUI(): List<PostItemUI>? = widgets?.map {
        it.toPostItemUI()
    }

    fun Post.toPostItemUI() = PostItemUI(
        uuid = uuid,
        cityId = cityId,
        page = page,
        lastPostDate = lastPostDate,
        widgetType = widgetType,
        data = data?.toPostDataItemUI(),
        onItemClicked = {}
    )

    private fun PostData.toPostDataItemUI() = PostDataItemUI(
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
        items = items?.toImagesItemUI()
    )

    private fun List<ImageItem>.toImagesItemUI(): List<ImageItemUI> {
        return map { ImageItemUI(imageUrl = it.imageUrl) }
    }

    ////////// UI Model -------> Post External Model //////////

    fun PostItemUI.toPost() = Post(
        uuid = uuid,
        cityId = cityId,
        page = page,
        lastPostDate = lastPostDate,
        widgetType = widgetType,
        data = data?.toPostData()
    )

    private fun PostDataItemUI.toPostData() = PostData(
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
        items = items?.toImagesItems()
    )

    private fun List<ImageItemUI>.toImagesItems(): List<ImageItem> {
        return map { ImageItem(imageUrl = it.imageUrl) }
    }
}