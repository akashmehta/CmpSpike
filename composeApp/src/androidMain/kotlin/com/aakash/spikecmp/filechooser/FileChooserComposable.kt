package com.aakash.spikecmp.filechooser

import android.util.Log
import androidx.compose.runtime.Composable
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.dialogs.FileKitMode
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher
import io.github.vinceglb.filekit.dialogs.openFilePicker

@Composable
actual fun FileChooserComposable() {
    rememberFilePickerLauncher (
        mode = FileKitMode.Multiple(),
        onResult = { file ->
            Log.d("FileChooserComposable", "Selected file: $file")
        }
    ).launch()
    Log.d("FileChooserComposable", "open dialog")
}