package com.lelestacia.submissioncompose.feature_anime.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lelestacia.submissioncompose.R
import com.lelestacia.submissioncompose.ui.theme.Beige

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Beige)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_sekolah),
            contentDescription = "Foto Profile",
            modifier = modifier
                .width(150.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit,
        )
        Text(
            text = stringResource(id = R.string.name),
            modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = stringResource(id = R.string.email),
            modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}