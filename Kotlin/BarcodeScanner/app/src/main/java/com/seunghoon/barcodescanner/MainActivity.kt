package com.seunghoon.barcodescanner

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.Uri
import android.os.Bundle
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.barcode.common.Barcode
import com.seunghoon.barcodescanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val permissionManager: PermissionManager by lazy {
        PermissionManager(this)
    }

    private val sensorManager: SensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activity = this
        permissionManager.checkUserPermission()

        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    @OptIn(ExperimentalGetImage::class)
    internal fun startCamera() {
        // 카메라 수명주기와 Activity 수명주기를 바인딩 하는데 사용
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        // 기본 스레드에서 실행되는 Executor
        val executor = ContextCompat.getMainExecutor(this)

        cameraProviderFuture.addListener(
            {
                // 카메라 수명주기를 애플리케이션 내 LifecycleOwner에 바인딩하는데 사용
                val cameraProvider = cameraProviderFuture.get()
                // ImageAnalyzer 객체 획득
                val imageAnalyzer = ImageAnalysis.Builder().build().also {
                    it.setAnalyzer(
                        executor, ImageAnalyzer(
                            onSuccess = this::onBarcodeScanSuccess,
                            onFailure = this::onBarcodeScanFailure,
                        )
                    )
                }


                // Lifecycle과의 모든 binding을 해제
                cameraProvider.unbindAll()
                // this에 해당하는 lifecycle에 바인딩
                cameraProvider.bindToLifecycle(
                    this,
                    // 후면 카메라를 기본으로 설정
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    // 이미지 분석
                    imageAnalyzer,
                    // Preview 초기화
                    getPreview(),
                )
            },
            executor
        )
    }

    private fun getPreview(): Preview {
        // 카메라 Preview 설정
        return Preview.Builder().build()
            .also { it.setSurfaceProvider(binding.viewFinder.surfaceProvider) }
    }

    private fun onBarcodeScanSuccess(barcodes: MutableList<Barcode>) {
        barcodes.forEach {
            val value = it.rawValue
            when (it.valueType) {
                // QR 코드인 경우
                Barcode.FORMAT_CODABAR -> {
                    // 외부 url로 intent
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(value)))
                }
                // 일반 바코드
                else -> {
                    if (binding.tvBarcode.text.toString() != value) {
                        binding.tvBarcode.text = value.toString()
                    }
                }
            }
        }
    }

    private fun onBarcodeScanFailure(message: String) {
        binding.tvBarcode.text = message
    }
}
