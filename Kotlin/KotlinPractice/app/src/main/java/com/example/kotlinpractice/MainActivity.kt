package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button : Button = findViewById(R.id.button)

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        })

        // 람다식 사용조건

        // 1. Kotlin interface가 아닌 자바 인터페이스여야 합니다.
        // 2. 그 인터페이스는 딱 하나의 메소드만 가져야 합니다.

        button.setOnClickListener {

        }
    }
}