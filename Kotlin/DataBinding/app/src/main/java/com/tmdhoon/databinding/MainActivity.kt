package com.tmdhoon.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.tmdhoon.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btBinding.setOnClickListener {
            if (binding.etInput.text != null) {
                val user = User(binding.etInput.text.toString())
                binding.main = user
                binding.invalidateAll()

            }
        }
    }
}