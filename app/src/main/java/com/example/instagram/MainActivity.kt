package com.example.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.compose.instagram.ui.theme.InstagramTheme
import com.compose.instagram.ui.view.HomeScreen
import com.google.firebase.Firebase
import com.google.firebase.initialize


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.initialize(this)
        setContent {
            InstagramTheme {
                HomeScreen()
            }
        }
    }
}

