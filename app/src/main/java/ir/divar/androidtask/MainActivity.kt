package ir.divar.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.divar.androidtask.data.repository.PlaceRepository
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.city.CityViewModel
import ir.divar.androidtask.feature.post.PostViewModel
import ir.divar.androidtask.feature.postDetail.PostDetailsViewModel
import ir.divar.androidtask.ui.screen.MainLayout
import ir.divar.androidtask.ui.theme.AndroidTaskTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var postRepository: PostRepository

    @Inject
    lateinit var placeRepository: PlaceRepository

//    private val cityViewModel: CityViewModel by viewModels()
//    private val postViewModel: PostViewModel by viewModels()
//    private val postDetailsViewModel: PostDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTaskTheme {
                MainLayout()
            }
        }
    }
}