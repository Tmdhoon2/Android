package com.example.actionbarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.actionbarnavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Homebutton 메뉴를 활성화
        supportActionBar?.setHomeButtonEnabled(true)
        // HomeButton을 노출
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // HomeButton의 아이콘 설정
        // supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}