package com.aakash.spikecmp.filechooser

import androidx.compose.runtime.Composable
import io.github.vinceglb.filekit.dialogs.FileKitMode
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher

@Composable
actual fun FileChooserComposable() {

    val launcher = rememberFilePickerLauncher (
        mode = FileKitMode.Multiple()
    ) { files ->
        println(files)
    }
    launcher.launch()
}