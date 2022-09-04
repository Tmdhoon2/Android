package com.example.githubapisample.contract;

import android.widget.AdapterView;

import com.example.githubapisample.model.User;

import java.util.List;

// Adapter contract
public interface UserAdapterContract {

    // Adapter 의 View
    interface View{
        void notifyAdapter();   // Ui Update

        void setOnClickListener(OnItemClick clickListener);     // Adapter Click Listener
    }

    // Adapter 의 Model
    interface Model{
        void setData(List<User> users);     // Adapter Data Update
    }
}
