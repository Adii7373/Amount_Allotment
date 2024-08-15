package com.example.amtallotement


import android.drm.DrmStore.Playback
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HomeiScreen(uri: Uri) {
    AndroidView(factory = { context ->
        VideoView(context).apply {
            setVideoURI(uri)
            setMediaController(null) // Disable media controller

            setOnPreparedListener { mediaPlayer ->
                mediaPlayer.isLooping = true // Set looping to true
            }

            start()
        }
    }, modifier = Modifier.fillMaxHeight(), update = { view ->
        view.setVideoURI(uri)
        view.start()
    })
}

@Composable
fun VideooScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    val videoUri = Uri.parse("android.resource://${context.packageName}/" + R.raw.textedit)

    Box(modifier = Modifier.fillMaxSize()) {
        HomeiScreen(uri = videoUri) // Use HomeiScreen here
    }
}