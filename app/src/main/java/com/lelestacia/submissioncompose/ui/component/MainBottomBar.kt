package com.lelestacia.submissioncompose.ui.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lelestacia.submissioncompose.feature_anime.Screen
import com.lelestacia.submissioncompose.ui.NavigationItem
import com.lelestacia.submissioncompose.ui.theme.Brown2

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItem = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Filled.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = "Favorite",
            icon = Icons.Filled.Favorite,
            screen = Screen.Favorite
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Filled.Person,
            screen = Screen.Profile
        )
    )
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Brown2,
    ) {
        navigationItem.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color.White
                    )
                },
                label = { Text(item.title, color = Color.White) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}