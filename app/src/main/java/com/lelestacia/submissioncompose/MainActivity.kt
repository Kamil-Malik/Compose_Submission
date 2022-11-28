package com.lelestacia.submissioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.ui.component.AnimeRow
import com.lelestacia.submissioncompose.ui.theme.SubmissionComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubmissionComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val animeList: List<AnimeModel> by viewModel.getData().collectAsState()
                    MainScreen(animeList = animeList)
                }
            }
        }
    }
}

@Composable
fun MainScreen(animeList: List<AnimeModel>) {
    LazyColumn {
        items(items = animeList, key = { it.title }) { anime ->
            AnimeRow(model = anime, onClicked = {

            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionComposeTheme {

    }
}