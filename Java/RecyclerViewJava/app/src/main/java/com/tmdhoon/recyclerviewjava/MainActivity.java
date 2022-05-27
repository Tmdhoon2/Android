package com.tmdhoon.recyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tmdhoon.recyclerviewjava.databinding.ActivityMainBinding;
import com.tmdhoon.recyclerviewjava.databinding.ListItemBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();


        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        int i = 0;

        binding.btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainData mainData = new MainData(R.drawable.ic_launcher_background, "DMS 안드로이드 화이팅","리사이클러뷰 연습중");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();

            }
        });
    }
}