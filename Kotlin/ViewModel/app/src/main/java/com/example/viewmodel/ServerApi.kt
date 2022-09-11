package com.example.viewmodel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServerApi {

    @GET("posts/1")
    fun getPost() : Call<Post>

    @GET("posts/{number}")
    fun getPost2(
        @Path("number") number : Int
    ) : Call<Post>

}