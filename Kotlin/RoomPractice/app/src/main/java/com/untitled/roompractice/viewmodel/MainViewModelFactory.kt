package com.untitled.roompractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.untitled.roompractice.database.DemoDatabase

internal class MainViewModelFactory(
    private val database: DemoDatabase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(database) as T
    }
}