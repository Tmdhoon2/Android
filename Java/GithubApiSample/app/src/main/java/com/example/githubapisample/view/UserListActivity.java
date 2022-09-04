package com.example.githubapisample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.githubapisample.R;
import com.example.githubapisample.adapters.UserAdapter;
import com.example.githubapisample.contract.UserListContract;
import com.example.githubapisample.databinding.ActivityMainBinding;
import com.example.githubapisample.model.User;
import com.example.githubapisample.presenter.UserListPresenter;

public class UserListActivity extends AppCompatActivity implements UserListContract.View, View.OnClickListener {
    private static final String TAG = "UserListActivity";

    private UserListPresenter presenter;
    private UserAdapter userAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initUI();
    }

    private void initUI() {
        binding.btnRest.setOnClickListener(this);

        userAdapter = new UserAdapter(this);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(userAdapter);

        presenter = new UserListPresenter(this);
        presenter.setUserAdapterModel(userAdapter);
        presenter.setUserAdapterView(userAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_rest: presenter.requestDataFromServer(); break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponseFailure(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}