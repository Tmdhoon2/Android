package com.seunghoon.barcodescanner

import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

@ExperimentalGetImage
internal class ImageAnalyzer(
    private val onSuccess: (MutableList<Barcode>) -> Unit,
    private val onFailure: (message: String) -> Unit,
) : ImageAnalysis.Analyzer {
    // 카메라 매 프레임마다 호출
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        mediaImage?.run {
            val image = InputImage.fromMediaImage(
                mediaImage,
                imageProxy.imageInfo.rotationDegrees,
            )
            val options = BarcodeScannerOptions.Builder()
                .setBarcodeFormats(
                    Barcode.FORMAT_EAN_13,
                    Barcode.FORMAT_EAN_8,
                    Barcode.FORMAT_QR_CODE,
                )
                .build()
            val barcodeScanner = BarcodeScanning.getClient(options)

            barcodeScanner.process(image).addOnSuccessListener {
                onSuccess(it)
            }.addOnFailureListener {
                onFailure("지원하지 않는 형식입니다.")
            }.addOnCompleteListener {
                mediaImage.close()
                imageProxy.close()
            }
        }
    }
}
