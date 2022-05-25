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

        val profilelist = arrayListOf(
            Profiles(R.drawable.profile, "강용수", 1201, "프론트엔드"),
            Profiles(R.drawable.profile, "강지인", 1202, "프론트엔드"),
            Profiles(R.drawable.profile, "길근우", 1203, "백엔드"),
            Profiles(R.drawable.woman, "김민채", 1204, "백엔드"),
            Profiles(R.drawable.profile, "김은오", 1205, "안드로이드"),
            Profiles(R.drawable.profile, "김정현", 1206, "프론트엔드"),
            Profiles(R.drawable.profile, "김주원", 1207, "안드로이드"),
            Profiles(R.drawable.profile, "김현민", 1208, "임베디드"),
            Profiles(R.drawable.profile, "마재영", 1209, "프론트엔드"),
            Profiles(R.drawable.woman, "유나현", 1210, "정보보안"),
            Profiles(R.drawable.profile, "유현담", 1211, "게임 개발"),
            Profiles(R.drawable.woman, "윤정민", 1212, "프론트엔드"),
            Profiles(R.drawable.profile, "정승훈", 1213, "안드로이드"),
            Profiles(R.drawable.profile, "정지관", 1214, "프론트엔드"),
            Profiles(R.drawable.profile, "조문성", 1215, "정보보안"),
            Profiles(R.drawable.woman, "최하은", 1216, "안드로이드"),
            Profiles(R.drawable.woman, "한예슬", 1217, "프론트엔드"),
            Profiles(R.drawable.profile, "홍승재", 1218, "ios"),
        )
        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profilelist)
    }
}