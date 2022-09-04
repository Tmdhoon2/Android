package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View{
    private lateinit var binding: ActivityMainBinding
    private lateinit var model : Contract.Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt1.setOnClickListener {
            model.getUserInfo()
        }

    }

    override fun showUserInfo(model: UserInfo) {
        binding.tv1.text = model.name
        binding.tv2.text = model.pw
    }
}