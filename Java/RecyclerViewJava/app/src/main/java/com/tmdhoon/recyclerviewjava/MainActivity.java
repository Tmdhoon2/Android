package com.tmdhoon.recyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tmdhoon.recyclerviewjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainAdapter mainAdapter;
    private LinearLayoutManager linearLayoutManager;

    private List<MainData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        binding.recyclerview.setLayoutManager(linearLayoutManager);

        mainAdapter = new MainAdapter(list);

        binding.recyclerview.setAdapter(mainAdapter);

        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(new MainData(binding.etInput.getText().toString()));
                mainAdapter.notifyDataSetChanged();
                binding.etInput.setText("");
            }
        });

    }
}