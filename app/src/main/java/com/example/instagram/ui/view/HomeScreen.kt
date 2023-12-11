package com.compose.instagram.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagram.data.model.Feed
import com.example.instagram.data.model.Story
import com.example.instagram.data.repository.stories
import com.example.instagram.ui.theme.DividerColor
import com.example.instagram.ui.theme.spacingMedium
import com.example.instagram.ui.view.InstagramToolBar
import com.example.instagram.ui.view.StoryItem

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        InstagramToolBar()

        StoryList(stories = stories)

        Divider(color = DividerColor, thickness = 0.2.dp)

        FeedItem(
            feed = Feed(
                userNickname = "denisse",
                localName = "San Andres - Tzompantepec",
                userAvatar = "https://cdn.brasildefato.com.br/media/d3e65c869db03180a7d34b1569ccdc04.jpg",
                imageUrl = "https://i.pinimg.com/originals/2b/43/cf/2b43cf682ec5697cedcd6d75df3a7392.png",
                description = "Ojos gitanos oblicuos",
                postedAgo = "Hace 21 horas"
            )
        )
    }
}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(stories) { _, item ->
            StoryItem(story = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}