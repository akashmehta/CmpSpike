package com.aakash.spikecmp.filechooser

import androidx.compose.runtime.Composable
import io.github.vinceglb.filekit.dialogs.FileKitMode
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher

@Composable
fun FileChooserComposable() {

    val launcher = rememberFilePickerLauncher (
        mode = FileKitMode.Multiple()
    ) { files ->

    }
}