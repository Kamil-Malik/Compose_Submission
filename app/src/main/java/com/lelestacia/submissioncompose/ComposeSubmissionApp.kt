package com.lelestacia.submissioncompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lelestacia.submissioncompose.feature_anime.Screen
import com.lelestacia.submissioncompose.feature_anime.detail.screen.DetailScreen
import com.lelestacia.submissioncompose.feature_anime.favorite.screen.FavoriteScreen
import com.lelestacia.submissioncompose.feature_anime.home.screen.HomeScreen
import com.lelestacia.submissioncompose.feature_anime.profile.screen.ProfileScreen
import com.lelestacia.submissioncompose.ui.component.MainBottomBar
import com.lelestacia.submissioncompose.ui.component.MainTopBar
import com.lelestacia.submissioncompose.ui.theme.Brown2

@Composable
fun ComposeSubmissionApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Brown2)
    Scaffold(
        topBar = {
            MainTopBar()
        },
        modifier = modifier,
        bottomBar = {
            if (currentRoute != Screen.DetailAnime.route) {
                MainBottomBar(navController = navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(onClicked = { title ->
                    navController.navigate(Screen.DetailAnime.createRoute(title))
                })
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen(onClicked = { title ->
                    navController.navigate(Screen.DetailAnime.createRoute(title))
                })
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailAnime.route,
                arguments = listOf(navArgument("animeTitle") { type = NavType.StringType }),
            ) {
                val title = it.arguments?.getString("animeTitle") ?: ""
                DetailScreen(
                    title = title,
                )
            }
        }
    }
}