package com.example.githubapisample.contract;

import com.example.githubapisample.model.User;
import com.example.githubapisample.model.UserList;

import java.util.List;

public interface UserListContract {

    // Model 인터페이스
    interface Model {
        // Presenter 구현
        interface onFinishedListener {
            void onFinished(List<User> users);  // 통신 성공 시 사용
        }

        // Model 구현 & Presenter 호출
       void getUserList(onFinishedListener onFinishedListener);
    }

    // View 인터페이스 & Presenter 호출
    interface View {
        void showProgress();

        void hideProgress();

        void showToast(String message);

        void onResponseFailure(String errorMsg);
    }

    // Presenter 인터페이스 & View 호출
    interface Presenter {
        void onDestroy();

        void requestDataFromServer();

        void setUserAdapterModel(UserAdapterContract.Model model);

        void setUserAdapterView(UserAdapterContract.View view);
    }
}