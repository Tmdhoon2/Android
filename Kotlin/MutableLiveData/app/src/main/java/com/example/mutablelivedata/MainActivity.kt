package com.example.mutablelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var textView : TextView
    private var liveData : MutableLiveData<String> = MutableLiveData()
    private var text = "Hello world!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        textView = findViewById(R.id.textView)

        liveData.observe(this, Observer{
            textView.text = it
        })

        button1.setOnClickListener {
            liveData.value = "Hello world!"
        }

        button2.setOnClickListener {
            liveData.value = "Hi hell"
        }

    }
}