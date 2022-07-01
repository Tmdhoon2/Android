package com.example.bottomnavigationviewjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.bottomnavigationviewjava.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private RestaurantFragment restaurantFragment = new RestaurantFragment();
    private CheckFragment checkFragment = new CheckFragment();
    private NotifyFragment notifyFragment = new NotifyFragment();
    private MypageFragment mypageFragment = new MypageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction;
        transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, restaurantFragment).commitNowAllowingStateLoss();

        binding.bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();

                switch (id){
                    case R.id.menu_restaurant:
                        transaction.replace(R.id.frameLayout, restaurantFragment).commitAllowingStateLoss();
                        break;
                    case R.id.menu_check:
                        transaction.replace(R.id.frameLayout, checkFragment).commitAllowingStateLoss();
                        break;
                    case R.id.menu_notify:
                        transaction.replace(R.id.frameLayout, notifyFragment).commitAllowingStateLoss();
                        break;
                    case R.id.menu_mypage:
                        transaction.replace(R.id.frameLayout, mypageFragment).commitAllowingStateLoss();
                        break;

                }
                return true;
            }
        });
    }
}