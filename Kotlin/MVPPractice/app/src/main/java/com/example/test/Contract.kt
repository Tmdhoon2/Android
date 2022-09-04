package com.example.test

interface Contract {

    interface Model{
        fun getUserInfo(model: UserInfo)
    }

    interface View{
        fun showUserInfo()
    }

    interface Presenter{
        fun requestInfo(name: String, pw : String)
    }

}