package com.lelestacia.submissioncompose.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lelestacia.submissioncompose.data.model.AnimeModel

@Composable
fun HeaderDetail(anime: AnimeModel, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.BottomCenter, modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.4f)
    ) {
        AsyncImage(
            model = anime.cover_url,
            contentDescription = "Cover URL",
            modifier = modifier
                .width(150.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
@Preview(device = Devices.PIXEL_3_XL, showBackground = true, showSystemUi = true)
fun PreviewHeader() {
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
    HeaderDetail(anime = example)
}