package com.example.myapplication

import android.icu.text.CaseMap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ImageView = findViewById<ImageView>(R.id.imageView)
        var count = findViewById<TextView>(R.id.count)
        val smash = findViewById<Button>(R.id.smashbutton)
        var combo = findViewById<TextView>(R.id.combo)
        val reset = findViewById<Button>(R.id.resetbutton)
        var a = 0
        var b =0

        smash.setOnClickListener {
            a += 1
            b += 1
            count.text = a.toString()
            combo.text = b.toString()
            val curTime = System.currentTimeMillis()
        }
        reset.setOnClickListener {
            a = 0
            b = 0
            count.text = a.toString()
            combo.text = b.toString()
        }


    }
}