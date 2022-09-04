package com.example.githubapisample.model;

import android.util.Log;

import androidx.core.provider.FontsContractCompat;

import com.example.githubapisample.contract.UserListContract;
import com.example.githubapisample.network.ApiProvider;
import com.example.githubapisample.network.ServerApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListModel implements UserListContract.Model {

    private final String GITHUB_TOKEN = "token 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";

    List<User> users = new ArrayList<>();
    int count = 0;

    @Override
    public void getUserList(final onFinishedListener onFinishedListener) {

        final ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);

        Call<List<UserList>> call = serverApi.getUsers(GITHUB_TOKEN);

        call.enqueue(new Callback<List<UserList>>() {
            @Override
            public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                if(response.isSuccessful()){
                    List<UserList> userLists = response.body();
                    count = userLists.size();

                    for (UserList user : userLists){
                        Call <User> subCall = serverApi.getUserInfo(GITHUB_TOKEN, user.getLogin());

                        subCall.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                count--;

                                if(response.isSuccessful()){
                                    users.add(response.body());
                                    if(count == 0){
                                        onFinishedListener.onFinished(userLists);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserList>> call, Throwable t) {

            }
        });
    }
}
