package ir.divar.androidtask.data.service

import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @POST("list")
    fun getPostList(
        @Query("city") selectedCityId: Int, @Body body: PostListRequest
    ): Response<PostListDto>

    @GET("view/{postToken}")
    fun getPostView(@Path("postToken") postToken: String): Response<PostViewDto>
}