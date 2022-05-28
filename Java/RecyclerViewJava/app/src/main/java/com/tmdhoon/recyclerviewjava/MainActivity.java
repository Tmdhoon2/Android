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

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<String> name = new ArrayList<>(Arrays.asList("DMS"));
        ArrayList<String> title = new ArrayList<>(Arrays.asList("리사이클러뷰"));

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);
        binding.btnAdd.setOnClickListener(new View.OnClickListener
(){
            @Override
            public void onClick(View view) {
                MainData mainData = new MainData(R.drawable.ic_launcher_foreground, "DMS 화이팅", "리사이클러뷰");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();

            }
        });
    }
}