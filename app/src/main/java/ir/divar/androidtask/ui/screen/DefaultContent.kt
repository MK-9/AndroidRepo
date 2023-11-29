package ir.divar.androidtask.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.divar.androidtask.feature.city.CityScreen
import ir.divar.androidtask.feature.city.CityViewModel
import ir.divar.androidtask.feature.post.PostScreen
import ir.divar.androidtask.feature.postDetail.PostDetailScreen

@Composable
fun DefaultContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    cityViewModel: CityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.City.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(
            route = Screen.City.route,
            arguments = arrayListOf(),
            deepLinks = arrayListOf(),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null
        ) {
            CityScreen(navController, cityViewModel) {
                navController.navigate(Screen.Post.route)
            }
        }

        composable(
            route = Screen.Post.route,
            arguments = arrayListOf(),
            deepLinks = arrayListOf(),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null
        ) {
            PostScreen(navController)
        }

        composable(
            route = Screen.PostDetails.route,
            arguments = arrayListOf(),
            deepLinks = arrayListOf(),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null
        ) {
            PostDetailScreen(navController)
        }
    }
}