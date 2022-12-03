package com.lelestacia.submissioncompose.feature_anime.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lelestacia.submissioncompose.R
import com.lelestacia.submissioncompose.data.model.AnimeModel
import com.lelestacia.submissioncompose.ui.theme.Brown2

@Composable
fun AnimeRow(
    title: String,
    episode: Int,
    status: String,
    score: Double,
    coverUrl: String,
    onClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier.fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(modifier = modifier
            .clickable { onClicked(title) }
            .background(Brown2)) {
            AsyncImage(
                model = coverUrl,
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
            )
            Column(modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.rating, score),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Icon Rating",
                        modifier = modifier
                            .padding(horizontal = 4.dp)
                            .size(16.dp),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(id = R.string.episode, episode.toString()),
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Text(
                    text = stringResource(id = R.string.status, status),
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3, showSystemUi = true)
@Composable
fun PreviewAnimeRow() {
    Column {
        val example = AnimeModel(
            title = "Kawaii dake ja Nai Shikimori-san",
            score = 6.94,
            rank = 4255,
            first_description = "Yuu Izumi leads a high school life filled with one mishap after another. No matter how improbable the situation, unfortunate events strike him at every turn. In possession of such terrible luck, Izumi enters his second year with a single wish in mind—to spend more time with his affectionate girlfriend, Micchon Shikimori.\n",
            second_description = "Cute, athletic, and caring, Shikimori is immensely popular at their school. But since they began dating a year ago, Izumi has witnessed a surprising side to his otherwise adorable girlfriend: when the need arises, she turns incredibly cool! His misfortunes are easily avoided when she is there to protect him with an awe-inspiring look on her face. Charming in every way, she never ceases to make his heart skip a beat. Unfortunate as he may be, Izumi is sure to see his days of bad luck end thanks to the cute yet cool Shikimori.",
            cover_url = "https://cdn.myanimelist.net/images/anime/1995/121695.jpg",
            type = "TV",
            episode = 12,
            status = "Finished Airing",
            premiered = "Spring 2022"
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..10) {
                item {
                    AnimeRow(title = example.title,
                        episode = example.episode,
                        status = example.status,
                        score = example.score,
                        coverUrl = example.score.toString(),
                        onClicked = {})
                }
            }
        }

    }
}