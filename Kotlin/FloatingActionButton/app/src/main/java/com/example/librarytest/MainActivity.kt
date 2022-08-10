package com.example.librarytest

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.librarytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabMain.setOnClickListener{
            if(isFabOpen){
                ObjectAnimator.ofFloat(binding.fabShare, "translationY", 0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fabPhoto, "translationY", 0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 45f, 0f).apply { start() }
            }else{
                ObjectAnimator.ofFloat(binding.fabShare, "translationY", -360f).apply { start() }
                ObjectAnimator.ofFloat(binding.fabPhoto, "translationY", -180f).apply { start() }
                ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 0f, 45f).apply { start() }
            }

            isFabOpen = !isFabOpen
        }

    }
}