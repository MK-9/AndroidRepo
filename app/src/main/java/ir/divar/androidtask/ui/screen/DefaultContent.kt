package ir.divar.androidtask.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.divar.androidtask.feature.city.CityScreen
import ir.divar.androidtask.feature.post.PostScreen
import ir.divar.androidtask.feature.postDetail.PostDetailsScreen

@Composable
fun DefaultContent(
    navController: NavHostController,
    paddingValues: PaddingValues
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
            CityScreen(navController) {
                navController.navigate(route = Screen.Post.route + "/" + "${it.id}")
            }
        }

        composable(
            route = Screen.Post.route + "/{cityId}",
            arguments = listOf(navArgument("cityId") { type = NavType.IntType }),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null
        ) {
            PostScreen(navController) {
                navController.navigate(route = Screen.PostDetails.route + "/" + "${it.data?.token}")
            }
        }

        composable(
            route = Screen.PostDetails.route + "/{token}",
            arguments = listOf(navArgument("token") { type = NavType.StringType }),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null
        ) {
            PostDetailsScreen(navController)
        }
    }
}