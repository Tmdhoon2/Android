package com.example.bottomnavigationviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomnavigationviewkotlin.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mealFragment: MealFragment
    private lateinit var applyFragment: ApplyFragment
    private lateinit var notifyFragment: NotifyFragment
    private lateinit var mypageFragment: MypageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.setOnNavigationItemSelectedListener(onBottomNavigationSelectedListener)
    }

    private val onBottomNavigationSelectedListener = BottomNavigationView.OnNavigationItemReselectedListener{

        when(it.itemId){
            R.id.menu_meal ->{
                mealFragment = MealFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mealFragment).commit()
            }
            R.id.menu_apply ->{
                applyFragment = ApplyFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mealFragment).commit()
            }
            R.id.menu_notify ->{
                notifyFragment = NotifyFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mealFragment).commit()
            }
            R.id.menu_mypage ->{
                mypageFragment = MypageFragment.newInstatnce()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mealFragment).commit()
            }
        }
        true
    }
}

