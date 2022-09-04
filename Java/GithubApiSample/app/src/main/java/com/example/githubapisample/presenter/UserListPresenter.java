package com.example.githubapisample.presenter;

import com.example.githubapisample.contract.OnItemClick;
import com.example.githubapisample.contract.UserAdapterContract;
import com.example.githubapisample.contract.UserListContract;
import com.example.githubapisample.model.User;
import com.example.githubapisample.model.UserListModel;

import java.util.List;

public class UserListPresenter implements UserListContract.Presenter, UserListContract.Model.onFinishedListener, OnItemClick {

    private UserListContract.View view;
    private UserListContract.Model model;

    private UserAdapterContract.Model adapterModel;
    private UserAdapterContract.View adapterView;

    public UserListPresenter(UserListContract.View view) {
        this.view = view;
        this.model = new UserListModel();
    }

    @Override
    public void onItemClick(int position) {
        view.showToast(position + "번째 User 클릭");
    }

    @Override
    public void onFinished(List<User> users) {
        if(view != null){
            view.hideProgress();
            adapterModel.setData(users);
            adapterView.notifyAdapter();

        }
    }

    @Override
    public void onFailure(String errorMsg) {
        if(view != null){
            view.onResponseFailure(errorMsg);
            view.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestDataFromServer() {
        if(view != null){
            view.showProgress();
        }
        model.getUserList(this);
    }

    @Override
    public void setUserAdapterModel(UserAdapterContract.Model model) {
        adapterModel = model;
    }

    @Override
    public void setUserAdapterView(UserAdapterContract.View view) {
        this.adapterView = view;
        this.adapterView.setOnClickListener(this);
    }
}
