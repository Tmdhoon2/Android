package com.example.actionbarcustomizing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // layout을 통해 View를 생성
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = topBar

        textView2 = findViewById(R.id.textView2)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)


        topBar.run {
            textView2.text = "커스텀 액션바"
            textView2.setTextColor(Color.WHITE)

            button.setOnClickListener {
                textView.text = "액션바의 버튼을 눌렀습니다"
            }

        }
    }
}