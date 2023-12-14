package ir.divar.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ir.divar.androidtask.data.repository.PlaceRepository
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.ui.screen.MainLayout
import ir.divar.androidtask.ui.theme.AndroidTaskTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var postRepository: PostRepository

    @Inject
    lateinit var placeRepository: PlaceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTaskTheme {
                MainLayout()
            }
        }
    }
}