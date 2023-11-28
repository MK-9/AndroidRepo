package ir.divar.androidtask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.repository.PlaceRepository
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.ui.theme.AndroidTaskTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var postRepository: PostRepository

    @Inject
    lateinit var placeRepository: PlaceRepository


    companion object {
        const val ACCESS_TOKEN =
            "Basic YXBpa2V5OjY5Y1dxVW8wNGhpNFdMdUdBT2IzMmRXZXQjsllsVzBtSkNiwU9yLUxEamNDUXFMSzJnR29mS3plZg=="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            CoroutineScope(Dispatchers.Main).launch {
//                val result = placeRepository.getPlaceList(ACCESS_TOKEN)
                val result = placeRepository.findPlace(
                    ACCESS_TOKEN,
                    FindPlaceRequest(
                        lat = 35.717358,
                        long = 51.375076
                    )
                )
                when (result) {
                    is Result.InProgress -> {
                        Log.d("Result", "Progress")
                    }

                    is Result.OnSuccess -> {
                        Log.d("Result", "OnSuccess")

                        val city = result.data
                        Log.d("Result", "city: name " + "${city.name}")
//                        val dtp = result.data
//                        Log.d("Result", "city: size " + "${dtp.cities?.size}")
//
//                        dtp.cities?.forEach {
//                            Log.d("Result", "city: name " + "${it.name}")
//                        }
                    }

                    is Result.OnError -> {
                        Log.d("Result", "OnError")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTaskTheme {
        Greeting("Android")
    }
}