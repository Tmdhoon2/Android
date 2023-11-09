package com.example.viewmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val btnMainMoveToSecond: Button by lazy {
        findViewById(R.id.btn_main_move_to_second)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SecondActivity::class.java)
        btnMainMoveToSecond.setOnClickListener {
            startActivity(intent)
        }
    }
}