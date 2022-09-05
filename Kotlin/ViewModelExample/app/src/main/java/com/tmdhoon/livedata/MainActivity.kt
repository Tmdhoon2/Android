package com.tmdhoon.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tmdhoon.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.user = userViewModel

        val nameObserver = Observer<Int> { it ->
            binding.textViewHeight.text = it.toString();
        }

        userViewModel.height.observe(this, nameObserver)

        userViewModel.height.observe(this, Observer{
            binding.textViewHeight.text = it.toString()
        })
    }
}