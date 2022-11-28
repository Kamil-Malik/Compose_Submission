package com.lelestacia.submissioncompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lelestacia.submissioncompose.ui.theme.SubmissionComposeTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent { 
            SubmissionComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    
                }
            }
        }
    }
}