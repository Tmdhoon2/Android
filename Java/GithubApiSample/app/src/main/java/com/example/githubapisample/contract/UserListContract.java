package com.example.githubapisample.contract;

import com.example.githubapisample.model.User;
import com.example.githubapisample.model.UserList;

import java.util.List;

public interface UserListContract {

    // Model 인터페이스
    interface Model {
        interface onFinishedListener {
            void onFinished(List<User> users);

            void onFailure(String errorMsg);
        }


        void getUserList(onFinishedListener onFinishedListener);
    }

    // View 인터페이스
    interface View {
        void showProgress();

        void hideProgress();

        void showToast(String message);

        void onResponseFailure(String errorMsg);
    }

    // Presenter 인터페이스
    interface Presenter {
        void onDestroy();

        void requestDataFromServer();

        void setUserAdapterModel(UserAdapterContract.Model model);

        void setUserAdapterView(UserAdapterContract.View view);
    }
}