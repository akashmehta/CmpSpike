package com.aakash.spikecmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.aakash.spikecmp.camera.CameraComposable
import com.aakash.spikecmp.localdb.LocalDbManager

@Composable
@Preview
fun App(contextFactory: ContextFactory) {
    var openCamera by remember { mutableStateOf(false) }
    var dbValue: String? by remember { mutableStateOf(null) }
    MaterialTheme {
        val dbManager = LocalDbManager(contextFactory)
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

            Button(onClick = {
                dbManager.saveBooleanSetting("test", true)
                dbValue = dbManager.getBooleanSetting("test")
            }) { Text("DB Set Value True") }

            Button(onClick = {
                dbManager.saveBooleanSetting("test", false)
                dbValue = dbManager.getBooleanSetting("test")
            }) { Text("DB Set Value False") }

            dbValue?.let {
                Text("DB Value: $it")
            }
        }
    }
}