package ir.divar.androidtask.ui.screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import ir.divar.androidtask.R

sealed class Screen(
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {

    data object City : Screen(
        "store", R.string.city, Icons.Default.Home
    )

    data object Post : Screen(
        "post", R.string.post, Icons.Default.ShoppingCart
    )

    data object PostDetails : Screen(
        "postDetail", R.string.postDetails, Icons.Default.Place
    )
}
