package com.example.android.firstweekchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.firstweekchallenge.data.Account

class InfoViewModel(account: Account, password: String) : ViewModel() {
    var account : MutableLiveData<Account> = MutableLiveData()
    var password : MutableLiveData<String> = MutableLiveData()

    init{
        this.account.value = Account(account.email, account.fullName, account.phoneNumber)
        this.password.value = password
    }
    fun setEmail(email: String){
        account.value?.email = email
        account.postValue(account.value)
    }
    fun setFullName(fullName: String){
        account.value?.fullName = fullName
        account.postValue(account.value)
    }
}