package com.example.kotllinsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotllinsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
           startActivity(Intent(this@MainActivity, JavaActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this@MainActivity, KotlinActivity::class.java))
        }
        binding.button3.setOnClickListener {
            // Intent 로 VariableJavaActivity 를 타겟으로 지정하고 startActivity 로 실행
            startActivity(Intent(this@MainActivity, VariableJavaActivity::class.java))
        }
        binding.button4.setOnClickListener {
            // Intent 로 VariableJavaActivity 를 타겟으로 지정하고 startActivity 로 실행
            startActivity(Intent(this@MainActivity, VariableKotlinActivity::class.java))
        }
    }
}