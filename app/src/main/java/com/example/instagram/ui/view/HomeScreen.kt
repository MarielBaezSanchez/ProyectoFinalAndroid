package com.example.instagram.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagram.data.Story
import com.example.instagram.ui.theme.spacingMedium

@Composable
fun HomeScreen() {

    Column (modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {

        InstagramToolBar()

        val stories = listOf(
            Story(userNickName = "marielbaez", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "samaelbaez", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "arochU", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "sahuSA", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "unaHada", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "ilakechSBS", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "cecySA", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "robot", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "yeye", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "yeyo", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "mikaVS", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
            Story(userNickName = "Salazar", userAvatar = "https://i.redd.it/rmk3k21tcxu21.jpg"),
        )
        StoryList(stories = stories)
    }
}

@Composable
fun StoryList(stories:List<Story>){
    LazyRow(modifier = Modifier.padding(top = spacingMedium)){
        itemsIndexed(stories){_, item->
            StoryItem(story = item)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}