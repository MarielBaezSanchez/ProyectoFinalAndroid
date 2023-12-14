package com.compose.instagram.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.instagram.ui.theme.InstagramTheme
import com.example.instagram.data.model.Feed
import com.example.instagram.data.model.Story
import com.example.instagram.data.repository.feedList
import com.example.instagram.data.repository.stories
import com.example.instagram.ui.theme.spacingMedium
import com.google.firebase.database.FirebaseDatabase

@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        item {
            InstagramToolBar()
        }

        item {
            StoryList(stories = stories)
        }

        item {
            Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
        }

        feedList(feedList = feedList)
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

fun LazyListScope.feedList(feedList: List<Feed>) {
    itemsIndexed(feedList) { index, item ->
        FeedItem(feed = item)

        // Aquí puedes agregar la lógica para almacenar el feed en Firebase
        storeFeedToFirebase(index, item)
    }
}

fun storeFeedToFirebase(index: Int, feed: Feed) {
    val feedsRef = FirebaseDatabase.getInstance().getReference("feeds")

    // Utiliza el índice como identificador único del feed en Firebase
    val feedId = index.toString()

    // Almacena el feed en Firebase bajo el identificador único
    feedsRef.child(feedId).setValue(feed)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun DarkHomeScreenPreview() {
    InstagramTheme(darkTheme = true) {
        HomeScreen()
    }
}
