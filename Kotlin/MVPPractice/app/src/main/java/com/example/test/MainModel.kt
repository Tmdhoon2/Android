package com.example.test

import android.util.Log

class MainModel {
    var presenter: Contract.Presenter

    constructor(presenter: Contract.Presenter) {
        this.presenter = presenter

    }
}