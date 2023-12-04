package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.dao.PostDao
import ir.divar.androidtask.data.local.entity.PostEntity
import ir.divar.androidtask.data.repository.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostLocalDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val dao: PostDao,
) : PostLocalDataSource {

    private val mutex = Mutex()

    override suspend fun filterPosts(
        cityId: Int,
        page: Int,
        lastPostDate: Int
    ): Flow<List<PostEntity>> {
        return mutex.withLock {
            withContext(dispatcher.io()) {
                dao.filterPosts(cityId, page, lastPostDate)
            }
        }
    }

    override suspend fun updatePosts(post: List<PostEntity>) {
        mutex.withLock {
            withContext(dispatcher.io()) {
                dao.updatePosts(post)
            }
        }
    }
}