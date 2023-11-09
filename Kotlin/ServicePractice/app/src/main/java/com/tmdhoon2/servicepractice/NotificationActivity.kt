package com.tmdhoon2.servicepractice

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tmdhoon2.servicepractice.databinding.ActivityNotificationBinding

object Notification {
    const val CHANNEL_ID = "test1"
    const val NOTIFICATION_ID = 0
}

class NotificationActivity : AppCompatActivity() {

    private val binding: ActivityNotificationBinding by lazy {
        ActivityNotificationBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val notificationManager = NotificationManagerCompat.from(this)

        val intent = Uri.parse("https://www.youtube.com").let {
            Intent(Intent.ACTION_VIEW)
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, Notification.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_kotlin)
            .setContentTitle("테스트 입니다")
            .setContentText("테스트 알람의 내용입니다")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                createNotificationChannel()
            }
        }

        /*binding.    btnSendNotification.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show()
                notificationManager.notify(Notification.NOTIFICATION_ID, builder.build())
            } else {
                Toast.makeText(this, "Ignored", Toast.LENGTH_SHORT).show()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        }*/

       /* binding.btnMoveToServiceActivity.setOnClickListener {
            showToast("eifjeijj")
        }*/
    }

    private fun createNotificationChannel() {
        val name = getString(R.string.notification_channel_name)
        val description = getString(R.string.notification_channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(Notification.CHANNEL_ID, name, importance).apply {
            this.description = description
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}