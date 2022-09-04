package com.example.githubapisample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.githubapisample.adapters.UserAdapter;
import com.example.githubapisample.contract.UserListContract;
import com.example.githubapisample.databinding.ActivityMainBinding;
import com.example.githubapisample.presenter.UserListPresenter;

public class MainActivity extends AppCompatActivity implements UserListContract.View, View.OnClickListener {
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
        binding.
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}