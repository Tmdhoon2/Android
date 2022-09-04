package com.example.test

class UserPresenter : Contract.Presenter {

    private lateinit var model: UserInfo

    override fun requestInfo(name: String, pw : String) {
        model.name = name
        model.pw = pw
    }

}