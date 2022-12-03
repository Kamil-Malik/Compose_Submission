package com.lelestacia.submissioncompose.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.lelestacia.submissioncompose.feature_anime.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
