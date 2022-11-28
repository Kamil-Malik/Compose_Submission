package com.lelestacia.submissioncompose.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lelestacia.submissioncompose.data.model.AnimeModel

@Composable
fun AnimeRow(
    model: AnimeModel, onClicked: (AnimeModel) -> Unit, modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier.fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row {
            AsyncImage(
                model = model.cover_url,
                contentDescription = "Cover Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(100.dp)
                    .clickable { onClicked(model) }
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
            )
            Column(modifier = modifier.padding(8.dp)) {
                Text(text = model.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Rating\t\t\t\t:\t${model.score}")
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Icon Rating",
                        modifier = modifier
                            .padding(horizontal = 8.dp)
                            .size(16.dp)
                    )
                }
                Text(text = "Type\t\t\t\t\t\t:\t${model.type}")
                Text(text = "Episodes\t\t:\t${model.episode}")
                Text(text = "Status\t\t\t\t:\t${model.status}")
                Text(text = "Premiered\t:\t${model.premiered}")
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3, showSystemUi = true)
@Composable
fun PreviewAnimeRow() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
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
        AnimeRow(model = example, onClicked = { })
    }
}