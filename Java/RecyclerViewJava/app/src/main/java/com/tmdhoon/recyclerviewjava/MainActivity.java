package com.tmdhoon.recyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText editText;

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
        EditText editText = (EditText)findViewById(R.id.edittext);
        binding.btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainData mainData = new MainData(R.drawable.ic_baseline_dehaze_24, editText.getText());
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();

            }
        });
    }
}