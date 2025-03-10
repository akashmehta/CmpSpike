package com.aakash.spikecmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cmpspike.composeapp.generated.resources.Res
import cmpspike.composeapp.generated.resources.compose_multiplatform
import com.aakash.spikecmp.camera.CameraComposable

@Composable
@Preview
fun App() {
    var openCamera by remember { mutableStateOf(false) }
    MaterialTheme {
        Column(Modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            if (openCamera) {
                CameraComposable()
            }
            else {
                Button(onClick = {
                    openCamera = true
                }) { Text("Camera Opener") }
            }
        }
    }
}