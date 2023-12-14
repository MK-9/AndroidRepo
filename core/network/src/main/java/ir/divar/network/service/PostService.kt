package ir.divar.network.service

import ir.divar.network.models.PostDetailsDto
import ir.divar.network.models.PostsDto
import ir.divar.network.models.request.PostListRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @POST("post/list")
    suspend fun getPostList(
        @Query("city") selectedCityId: Int, @Body body: PostListRequest
    ): Response<PostsDto>

    @GET("post/view/{postToken}")
    suspend fun getPostView(@Path("postToken") postToken: String?): Response<PostDetailsDto>
}