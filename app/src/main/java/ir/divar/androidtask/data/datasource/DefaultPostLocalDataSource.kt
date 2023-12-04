package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.dao.PostDao
import ir.divar.androidtask.data.local.entity.PostEntity
import ir.divar.androidtask.data.repository.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostLocalDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val dao: PostDao,
) : PostLocalDataSource {

    override suspend fun getPostList(): Flow<List<PostEntity>> {
        return withContext(dispatcher.io()) {
            dao.getAllPosts()
        }
    }

    override suspend fun updatePosts(post: List<PostEntity>) {
        withContext(dispatcher.io()) {
            dao.updatePosts(post)
        }
    }
}