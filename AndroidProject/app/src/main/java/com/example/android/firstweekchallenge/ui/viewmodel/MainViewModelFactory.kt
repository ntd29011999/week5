package com.example.android.firstweekchallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.firstweekchallenge.data.Account
import java.lang.IllegalArgumentException

class MainViewModelFactory(val account: Account, val password: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AccountViewModel::class.java)){
            return AccountViewModel(account) as T
        }
        if(modelClass.isAssignableFrom(InfoViewModel::class.java)){
            return InfoViewModel(account, password) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}