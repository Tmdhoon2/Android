package com.example.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var secondActivityViewModel: SecondActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        secondActivityViewModel = ViewModelProvider(this)[SecondActivityViewModel::class.java]

        // TODO: viewmodel clear
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            viewModelStore.clear()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TEST", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TEST", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TEST", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TEST", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TEST", "onDestroy")
    }
}