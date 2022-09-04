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

// UserListContract.Model 을 상속받음
public class UserListModel implements UserListContract.Model {

    private final String GITHUB_TOKEN = "token";

    List<User> users = new ArrayList<>();
    int count = 0;

    // getUserList 구현
    @Override
    public void getUserList(final onFinishedListener onFinishedListener) {

        final ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);

        Call<List<UserList>> call = serverApi.getUsers(GITHUB_TOKEN);

        // userlist 를 가져오는 코드
        call.enqueue(new Callback<List<UserList>>() {
            @Override
            public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                if(response.isSuccessful()){
                    // 리스트에 response.body를 담음
                    List<UserList> userLists = response.body();
                    // count 에 리스트 크기를 저장
                    count = userLists.size();

                    // list 에서 객체를 꺼내 담는다
                    for (UserList user : userLists){
                        Call <User> subCall = serverApi.getUserInfo(GITHUB_TOKEN, user.getLogin());

                        // user 각각의 정보를 호출
                        subCall.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                count--;

                                if(response.isSuccessful()){
                                    users.add(response.body());

                                    // count == 0이면
                                    // onfinshlistenr 호출
                                    if(count == 0){
                                        onFinishedListener.onFinished(users);
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
