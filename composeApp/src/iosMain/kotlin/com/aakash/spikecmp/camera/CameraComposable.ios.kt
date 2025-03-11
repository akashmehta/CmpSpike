package com.aakash.spikecmp.camera

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureDeviceInput
import platform.AVFoundation.AVCaptureSession
import platform.AVFoundation.AVCaptureVideoPreviewLayer
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.requestAccessForMediaType
import platform.UIKit.UIViewController
import kotlin.OptIn
import kotlin.let

@Composable
actual fun CameraComposable() {
    val viewController = remember { CameraViewController() }
    UIKitView(
        factory = { viewController.view },
        update = { viewController.view }
    )
}

class CameraViewController : UIViewController(nibName = null, bundle = null) {
    private val captureSession = AVCaptureSession()
    private val videoPreviewLayer = AVCaptureVideoPreviewLayer(session = captureSession)

    override fun viewDidLoad() {
        super.viewDidLoad()
        setupCamera()
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun setupCamera() {
        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) { granted ->
            if (granted) {
                val videoDevice = AVCaptureDevice.defaultDeviceWithMediaType(AVMediaTypeVideo)
                println(videoDevice)
                val videoInput = videoDevice?.let { AVCaptureDeviceInput.deviceInputWithDevice(it, error = null) } as AVCaptureDeviceInput
                captureSession.addInput(videoInput)

                videoPreviewLayer.frame = view.bounds
                videoPreviewLayer.videoGravity = AVLayerVideoGravityResizeAspectFill
                view.layer.addSublayer(videoPreviewLayer)

                captureSession.startRunning()
            } else {
                println("Camera access denied")
            }
        }
    }
}