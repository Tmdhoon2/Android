package com.tmdhoon.threadexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.lang.Exception
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    private lateinit var btJava: Button
    private lateinit var btKotlin: Button
    var value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btJava = findViewById(R.id.btJava)
        btKotlin = findViewById(R.id.btKotlin)

        // 자바방식
        btJava.setOnClickListener {
            // SubThread 클래스를 생성해서
            val subThread = SubThread()
            // start
            subThread.start()
        }

        // 코틀린 방식
        btKotlin.setOnClickListener {
            Thread {
                for (i in 1..100) {
                    try {
                        sleep(1000)
                    } catch (e: Exception) {
                    }
                    value++
                    Log.d("TEST", "Kotlin Thread : " + value)
                }
            }.start()
        }
    }
}


class SubThread : Thread() {
    override fun run() {
        var value = 0
        for (i in 1..100) {
            try {
                sleep(1000)
            } catch (e: Exception) {
            }
            value++
            Log.d("TEST", "Java Thread : " + value)
        }
    }
}