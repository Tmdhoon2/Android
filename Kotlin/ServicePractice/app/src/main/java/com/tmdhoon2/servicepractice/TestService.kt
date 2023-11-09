package com.tmdhoon2.servicepractice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TestService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}