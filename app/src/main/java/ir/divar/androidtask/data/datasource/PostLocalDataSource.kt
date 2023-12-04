package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.PostDto

interface PostLocalDataSource {
    suspend fun getPostList(): List<PostDto>

    suspend fun insertPost(post: PostDto)
}