package com.lelestacia.submissioncompose.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lelestacia.submissioncompose.ui.theme.Brown2

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Brown2,
        title = {
            Text(
                text = "Dicoding Compose Submission",
                color = Color.White,
                modifier = modifier
                    .padding(8.dp)
            )
        }
    )
}

