package ir.divar.androidtask.feature.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.divar.androidtask.feature.CityScreen
import ir.divar.androidtask.feature.PostDetailScreen
import ir.divar.androidtask.feature.PostScreen

@Composable
fun DefaultContent(navController: NavHostController, paddingValues: PaddingValues) {
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
            CityScreen(navController)
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