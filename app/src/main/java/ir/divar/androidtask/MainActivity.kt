package ir.divar.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ir.divar.data.repository.PlaceRepository
import ir.divar.data.repository.PostRepository
import ir.divar.androidtask.ui.screen.MainLayout
import ir.divar.androidtask.ui.theme.AndroidTaskTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var postRepository: ir.divar.data.repository.PostRepository

    @Inject
    lateinit var placeRepository: ir.divar.data.repository.PlaceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTaskTheme {
                MainLayout()
            }
        }
    }
}