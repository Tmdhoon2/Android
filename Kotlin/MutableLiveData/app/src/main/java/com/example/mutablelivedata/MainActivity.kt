package com.example.mutablelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.mutablelivedata.R

class MainActivity : AppCompatActivity() {
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var textView : TextView
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var textView2 : TextView

    private var liveData : MutableLiveData<String> = MutableLiveData()
    private var liveData2 : MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        textView = findViewById(R.id.textView)

        textView2 = findViewById(R.id.textView2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        liveData.observe(this, Observer{
            textView.text = it
        })

        liveData2.observe(this, Observer {
            textView2.text = it
        })

        button1.setOnClickListener {
            liveData.value = "Hello world!"
        }

        button2.setOnClickListener {
            liveData.value = "Hi hell"
        }

        button3.setOnClickListener {
            liveData2.value = "Hello world!"
        }

        button4.setOnClickListener {
            liveData2.value = "Hi hell"
        }

    }
}