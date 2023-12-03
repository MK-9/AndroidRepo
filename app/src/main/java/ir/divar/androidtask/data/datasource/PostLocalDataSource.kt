package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.dto.PostDto

interface PostLocalDataSource {
    suspend fun getPostList(): List<PostDto>

    suspend fun insertPost(post:PostDto)
}