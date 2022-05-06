package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment

    companion object{
        const val TAG:String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity -onCreate() called")

        val bottom_nav : BottomNavigationView= findViewById(R.id.bottom_nav)


        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavigationSelectedListener)
    }

    private val onBottomNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.menu_home ->{
                Log.d(TAG, "MainAcitivity - 홈버튼 클릭!")
                homeFragment = HomeFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking ->{
                Log.d(TAG, "MainAcitivity - 랭킹버튼 클릭!")
                rankingFragment = RankingFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()

            }
            R.id.menu_profile ->{
                Log.d(TAG, "MainAcitivity - 프로필버튼 클릭!")
                profileFragment = ProfileFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }
        true


    }

}