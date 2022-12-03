package com.lelestacia.submissioncompose.feature_anime

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("cart")
    object Profile : Screen("profile")
    object DetailAnime : Screen("home/{animeTitle}") {
        fun createRoute(animeTitle: String) = "home/$animeTitle"
    }
}
