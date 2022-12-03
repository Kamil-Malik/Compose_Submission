package com.lelestacia.submissioncompose.feature_anime.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lelestacia.submissioncompose.R

@Composable
fun DetailAnimeDesc(descriptionOne: String, descriptionTwo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.paragraph, descriptionOne),
            textAlign = TextAlign.Justify,
            color = Color.Black
        )
        Text(
            text = stringResource(id = R.string.paragraph, descriptionTwo),
            textAlign = TextAlign.Justify,
            color = Color.Black
        )
    }
}