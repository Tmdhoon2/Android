package com.example.githubapisample.contract;

public interface UserListContract {

    // Model 인터페이스
    interface Model{
        interface onFinishedListener{
            void onFinished(List<Users> users);
            void onFailure(Throwable throwable);
        }


        void getUserList(onFinishedListener onFinishedListener);
    }

    // View 인터페이스
    interface View {
        void showProgress();

        void hideProgress();

        void showToast(String message);

        void onResponseFailure(Throwable throwable);
    }

    // Presenter 인터페이스
    interface Presenter{
        void onDestroy();

        void requestDataFromServer();

        void setUserAdapterModel(UserAdapterContract.Model model);

        void setUserAdapterView(UserAdapterContract.View view);
    }

}
