package com.pals.funnydogs.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pals.funnydogs.dogs.Dog
import com.pals.funnydogs.dogs.DogViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DogScreen(
    dogViewModel: DogViewModel = getViewModel()
) {
    val dogState = dogViewModel.dogState.collectAsState()

    Column {
        AppBar()
        if (dogState.value.loading)
            Loader()
        if (dogState.value.error != null)
            ErrorMessage(dogState.value.error!!)
        if (dogState.value.dog.message.isNotEmpty())
            DogView(dogState.value.dog)
    }
}

@Composable
fun DogView(dog: Dog){
    Box (modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
        ) {
        AsyncImage(
            model = dog.message,
            contentDescription =  "Cute Dog",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
) {
    TopAppBar(
        title = { Text(text = "Dogs") },
    )
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ErrorMessage(mesage:String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = mesage,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}