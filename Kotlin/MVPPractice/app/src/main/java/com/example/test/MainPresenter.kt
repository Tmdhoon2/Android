package com.example.test

class MainPresenter : Contract.Presenter{

    lateinit var view: Contract.View
    lateinit var mainModel: MainModel

    constructor(view: Contract.View) {
        this.view = view
        this.mainModel = MainModel(this)
    }


    override fun addNum(num1: Int, num2: Int) {
        view.showResult(num1 + num2)
    }

}