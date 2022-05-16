package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvprofile : RecyclerView = findViewById(R.id.rv_profile)

        val profilelist = arrayListOf(
            Profiles(R.drawable.profile, "강용수", 1, "프론트엔드"),
            Profiles(R.drawable.profile, "강지인", 2, "프론트엔드"),
            Profiles(R.drawable.profile, "길근우", 3, "백엔드"),
            Profiles(R.drawable.woman, "김민채", 4, "백엔드"),
            Profiles(R.drawable.profile, "김은오", 5, "안드로이드"),
            Profiles(R.drawable.profile, "김정현", 6, "프론트엔드"),
            Profiles(R.drawable.profile, "김주원", 7, "안드로이드"),
            Profiles(R.drawable.profile, "김현민", 8, "임베디드"),
            Profiles(R.drawable.profile, "마재영", 9, "프론트엔드"),
            Profiles(R.drawable.woman, "유나현", 10, "정보보안"),
            Profiles(R.drawable.profile, "유현담", 11, "게임 개발"),
            Profiles(R.drawable.woman, "윤정민", 12, "프론트엔드"),
            Profiles(R.drawable.profile, "정승훈", 13, "안드로이드"),
            Profiles(R.drawable.profile, "정지관", 14, "프론트엔드"),
            Profiles(R.drawable.profile, "조문성", 15, "정보보안"),
            Profiles(R.drawable.woman, "최하은", 16, "안드로이드"),
            Profiles(R.drawable.woman, "한예슬", 17, "프론트엔드"),
            Profiles(R.drawable.profile, "홍승재", 18, "ios"),
        )
        rvprofile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvprofile.setHasFixedSize(true)

        rvprofile.adapter = ProfileAdapter(profilelist)
    }
}