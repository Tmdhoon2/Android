package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View{
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(this)

        binding.bt1.setOnClickListener {
            val id = binding.et1.text.toString()
            val pw = binding.et2.text.toString()

            if(id != null && pw != null){
                presenter.addNum(Integer.parseInt(id), Integer.parseInt(pw))
            }
        }

    }

    override fun showResult(answer: Int) {
        binding.tv1.text = Integer.toString(answer)
    }
}