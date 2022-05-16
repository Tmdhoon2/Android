package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var policyFragment: PolicyFragment

    companion object{
        const val TAG:String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener(onBottomNavigationSelectedListener)
    }

    private val onBottomNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.menu_home ->{
                homeFragment = HomeFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking ->{
                rankingFragment = RankingFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()

            }
            R.id.menu_profile ->{
                profileFragment = ProfileFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
            R.id.menu_policy ->{
                policyFragment = PolicyFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, policyFragment).commit()
            }
        }
        true


    }

}