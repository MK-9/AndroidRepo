package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.dao.PostDao
import ir.divar.androidtask.data.model.dto.PostDto
import ir.divar.androidtask.data.model.entity.PostEntityMapper.toPostDto
import ir.divar.androidtask.data.model.entity.PostEntityMapper.toPostEntity
import ir.divar.androidtask.data.repository.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostLocalDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val dao: PostDao
) : PostLocalDataSource {

    override suspend fun getPostList(): List<PostDto> {
        return withContext(dispatcher.io()) {
            dao.getAllPosts().map {
                it.toPostDto()
            }
        }
    }

    override suspend fun insertPost(post: PostDto) {
        withContext(dispatcher.io()) {
            dao.insertPost(post.toPostEntity())
        }
    }
}