package com.example.instagram.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagram.data.model.Feed

@Composable
fun FeedItem(feed:Feed) {
}

@Preview
@Composable
fun FeedItemPreview(){
    FeedItem(feed = Feed(
        userNickname = "Mariel Báez",
        localName = "México",
        userAvatar = "",
        imageUrl = "",
        description = "",
        postedAgo = "Hace 5 días"
    )
    )
}