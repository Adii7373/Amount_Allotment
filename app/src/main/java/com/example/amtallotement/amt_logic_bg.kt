package com.example.amtallotement

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun HomeScriiloeen(uri: Uri) { // Changed composable name to HomeScreen
    AndroidView(factory = { context ->
        VideoView(context).apply {
            setVideoURI(uri)
            setMediaController(null)

            setOnPreparedListener { mediaPlayer ->
                mediaPlayer.isLooping = true
                mediaPlayer.start() // Start video after it's prepared
            }

            start() // Also start the video here
        }
    }, modifier = Modifier.fillMaxHeight(), update = { view ->view.setVideoURI(uri)
        view.start()
    })
}

@Composable
fun VideologicScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    val videoUri = Uri.parse("android.resource://${context.packageName}/" + R.raw.amtlogic)

    Box(modifier = Modifier.fillMaxSize()) {
        HomeScriiloeen(uri = videoUri) // Use the correct composable name
    }
}