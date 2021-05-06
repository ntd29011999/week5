package com.example.android.firstweekchallenge.ui.view

import com.example.android.firstweekchallenge.ui.viewmodel.AccountViewModel
import com.example.android.firstweekchallenge.ui.viewmodel.MainViewModelFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.firstweekchallenge.ui.utils.FullNameDialog
import com.example.android.firstweekchallenge.ui.utils.PhoneDialog
import com.example.android.firstweekchallenge.R
import com.example.android.firstweekchallenge.data.Account
import com.example.android.firstweekchallenge.data.DataStore
import com.example.android.firstweekchallenge.databinding.ActivityProfileBinding
import com.example.android.firstweekchallenge.ui.utils.EmailDialog


class ProfileActivity :
    AppCompatActivity(),
    PhoneDialog.OnFragmentManager,
    FullNameDialog.OnFragmentManager,
    EmailDialog.OnFragmentManager {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var accountViewModel: AccountViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        setupViewModel()
        setupObserver()
    }

    fun withEdtPhone(view: View) {
        PhoneDialog().show(supportFragmentManager, "PhoneDialog")
    }
    fun withEdtFullName(view: View) {
        FullNameDialog().show(supportFragmentManager, "FullNameDialog")
    }
    fun withEdtEmail(view: View) {
        EmailDialog().show(supportFragmentManager, "FullNameDialog")
    }

    override fun onPhoneSelected(phone: String) {
        Log.e("ProfileActivity", "phone: $phone")
        accountViewModel.setPhoneNumber(phone)
    }

    override fun onFullNameSelected(fullName: String) {
        Log.e("ProfileActivity", "fullName $fullName")
        accountViewModel.setFullName(fullName)
    }
    override fun onEmailSelected(email: String) {
        Log.e("ProfileActivity", "fullName $email")
        accountViewModel.setEmail(email)
    }
    private fun setupViewModel() {
        val account = Account(
            DataStore.email.toString(),
            DataStore.fullName.toString(),
            DataStore.phoneNumber.toString())
        viewModelFactory = MainViewModelFactory(account = account, password = "")
        accountViewModel = ViewModelProvider(this, viewModelFactory).get(AccountViewModel::class.java)
    }

    private fun setupObserver() {
        accountViewModel.account.observe(this, Observer {
            binding.edtPhone.setText(it.phoneNumber)
            binding.edtFullName.setText(it.fullName)
            binding.edtEmail.setText(it.email)
            binding.title.text = it.fullName
        })
    }

}