package com.example.githubapisample.network;

import com.example.githubapisample.model.User;
import com.example.githubapisample.model.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ServerApi {

    @GET("users")
    Call<List<UserList>> getUsers(
            @Header("Authorization") String token
    );

    @GET("users/{login}")
    Call<User> getUserInfo(
            @Header("Authorization") String token,
            @Path("login") String login
    );

}
