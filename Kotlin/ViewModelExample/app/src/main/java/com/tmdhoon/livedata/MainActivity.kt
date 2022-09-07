package com.tmdhoon.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tmdhoon.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // 뷰모델 연결
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ViewModelProvider 를 통해 Viewmodel 객체 획득
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        // xml 과 userViewModel 연결
        binding.user = userViewModel

        // 옵저버로 객체 지정
        val nameObserver = Observer<Int> { it ->
            binding.textViewHeight.text = it.toString();
        }

        userViewModel.height.observe(this, nameObserver)

        userViewModel.height.observe(this, Observer{
            binding.textViewHeight.text = it.toString()
        })
    }
}