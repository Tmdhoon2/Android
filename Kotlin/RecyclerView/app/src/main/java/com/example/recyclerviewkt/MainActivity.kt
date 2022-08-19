package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
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
            Profiles(R.drawable.profile, "대마고 박보검", 1201, "프론트엔드"),
            Profiles(R.drawable.profile, "순천", 1202, "프론트엔드"),
            Profiles(R.drawable.profile, "찣근우", 1203, "백엔드"),
            Profiles(R.drawable.woman, "김민채", 1204, "백엔드"),
            Profiles(R.drawable.profile, "대마초 김은오", 1205, "안드로이드"),
            Profiles(R.drawable.profile, "김정현봉식하회탈", 1206, "프론트엔드"),
            Profiles(R.drawable.profile, "김원주", 1207, "안드로이드"),
            Profiles(R.drawable.profile, "김현민군", 1208, "임베디드"),
            Profiles(R.drawable.profile, "마재명", 1209, "프론트엔드"),
            Profiles(R.drawable.woman, "유나현", 1210, "정보보안"),
            Profiles(R.drawable.profile, "유현담", 1211, "게임 개발"),
            Profiles(R.drawable.woman, "NULL", 1212, "프론트엔드"),
            Profiles(R.drawable.profile, "안드로이드 3짱", 1213, "안드로이드"),
            Profiles(R.drawable.profile, "부산소녀", 1214, "프론트엔드"),
            Profiles(R.drawable.profile, "조문성", 1215, "정보보안"),
            Profiles(R.drawable.woman, "대전", 1216, "안드로이드"),
            Profiles(R.drawable.woman, "한예슬", 1217, "프론트엔드"),
            Profiles(R.drawable.profile, "코코몽", 1218, "ios")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)



        binding.rvProfile.adapter = ProfileAdapter(profilelist)

    }
}