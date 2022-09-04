package com.example.githubapisample.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static final String BASE_URL = "https://api.github.com/";

    public static ApiProvider ourInstance = null;
    private static Retrofit retrofit = null;

    public ApiProvider(){
        if(ourInstance == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build();
        }
    }

    public static Retrofit getInstance(){
        if(ourInstance == null){
            ourInstance = new ApiProvider();
        }

        return retrofit;
    }

    private HttpLoggingInterceptor getIntercepter() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getIntercepter())
                .build();

        return client;
    }
}
