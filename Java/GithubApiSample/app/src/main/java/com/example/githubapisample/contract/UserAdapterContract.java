package com.example.githubapisample.contract;

import android.widget.AdapterView;

// Adapter contract
public interface UserAdapterContract {

    // Adapter 의 View
    interface View{
        void notifyAdapter();

        void setOnClickListener(OnItemClick clickListener);
    }

    // Adapter 의 Model
    interface Model{
        void setData(List<User> users);

        User user(int position);
    }
}
