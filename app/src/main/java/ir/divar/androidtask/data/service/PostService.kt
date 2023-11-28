package ir.divar.androidtask.data.service

import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @POST("post/list")
    suspend fun getPostList(
        @Header("x-access-token") accessToken: String?,
        @Query("city") selectedCityId: Int,
        @Body body: PostListRequest
    ): Response<PostListDto>

    @GET("post/view/{postToken}")
    suspend fun getPostView(
        @Header("x-access-token") accessToken: String?, @Path("postToken") postToken: String?
    ): Response<PostViewDto>
}