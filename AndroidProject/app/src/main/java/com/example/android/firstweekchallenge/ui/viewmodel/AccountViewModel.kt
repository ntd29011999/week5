package com.example.android.firstweekchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.firstweekchallenge.data.Account

class AccountViewModel(account: Account) : ViewModel() {
    var account : MutableLiveData<Account> = MutableLiveData()
    init{
        this.account.value = Account(account.email, account.fullName, account.phoneNumber)
    }
    fun setEmail(email: String){
        account.value?.email = email
        account.postValue(account.value)
    }
    fun setFullName(fullName: String){
        account.value?.fullName = fullName
        account.postValue(account.value)
    }
    fun setPhoneNumber(phoneNumber: String){
        account.value?.phoneNumber = phoneNumber
        account.postValue(account.value)
    }
}