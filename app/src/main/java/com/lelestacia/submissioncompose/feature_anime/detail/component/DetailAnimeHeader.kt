package com.lelestacia.submissioncompose.feature_anime.detail.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lelestacia.submissioncompose.R

@Composable
fun DetailAnimeHeader(
    title: String,
    episode: Int,
    status: String,
    score: Double,
    coverUrl: String,
    rank: Int,
    premiere: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = coverUrl, contentDescription = "Anime Cover", modifier = modifier.width(100.dp)
        )
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(top = 4.dp)
                ) {
                    Text(text = stringResource(id = R.string.rating, score), color = Color.Black)
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Icon Rating",
                        modifier = modifier
                            .padding(horizontal = 4.dp)
                            .size(16.dp)
                    )
                }
                Text(
                    text = stringResource(id = R.string.episode, episode.toString()),
                    color = Color.Black
                )
                Text(
                    text = stringResource(id = R.string.status, status),
                    color = Color.Black
                )
            }
            Column {
                Text(
                    text = "Rank #$rank",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h2,
                    color = Color.Black
                )
                Text(
                    text = stringResource(id = R.string.premiered, premiere),
                    color = Color.Black
                )
            }
        }
    }
}