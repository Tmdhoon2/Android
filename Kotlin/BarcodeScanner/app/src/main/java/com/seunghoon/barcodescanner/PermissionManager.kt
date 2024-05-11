package com.seunghoon.barcodescanner

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class PermissionManager(
    private val mainActivity: MainActivity,
) {
    private val permissionActivityLauncher by lazy {
        mainActivity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map[Manifest.permission.CAMERA] == true) {
                mainActivity.startCamera()
            } else {
                Toast.makeText(mainActivity, "권한을 허용해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    internal fun checkUserPermission() {
        if (cameraPermissionGranted()) {
            mainActivity.startCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun cameraPermissionGranted() = ContextCompat.checkSelfPermission(
        mainActivity, Manifest.permission.CAMERA,
    ) == PackageManager.PERMISSION_GRANTED

    private fun requestCameraPermission() {
        permissionActivityLauncher.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            )
        )
    }
}
