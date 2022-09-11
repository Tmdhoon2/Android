package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var mutableLiveData = MutableLiveData<String>()
    val liveData : LiveData<String>
        get() = mutableLiveData

    fun getPost1(){
        ApiProvider.retrofit.getPost().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                mutableLiveData.value = response.toString()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
    }

    fun getPost2(num : Int){
        ApiProvider.retrofit.getPost2(num).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                mutableLiveData.value = response.toString()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
    }


}