package com.example.android.firstweekchallenge.ui.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.firstweekchallenge.R
import com.example.android.firstweekchallenge.data.Account
import com.example.android.firstweekchallenge.data.DataStore
import com.example.android.firstweekchallenge.databinding.ActivityLoginBinding
import com.example.android.firstweekchallenge.ui.viewmodel.InfoViewModel
import com.example.android.firstweekchallenge.ui.viewmodel.MainViewModelFactory

class LogInAcitvity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupObserver()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val intentSignUpActivity = Intent(this, SignUpActivity::class.java)
        val intentListRestaurantActivity = Intent(this, ListRestaurantActivity::class.java)

        binding.btnSignUp.setOnClickListener {
            startActivity(intentSignUpActivity)
            //finish()
        }
        binding.apply {  btnLogin.setOnClickListener {
            if (edtEmail.text.trim().toString().isNullOrEmpty()) {
                edtEmail.setError("enter email please!");
            }
            if (edtPassword.text.trim().toString().isNullOrEmpty()) {
                binding.edtPassword.setError("enter password please!");
            }
            if (binding.edtEmail.text.trim().toString() == DataStore.email && binding.edtPassword.text.trim().toString() == DataStore.password) {
                Toast.makeText(applicationContext, "successful login!", Toast.LENGTH_SHORT).show()
                startActivity(intentListRestaurantActivity)
                //finish()
            } else {
                val alertDialogBuilder = android.app.AlertDialog.Builder(this@LogInAcitvity)
                alertDialogBuilder.setMessage("failed login!")
                alertDialogBuilder.setPositiveButton("OK") {
                        dialog: DialogInterface,
                        which: Int
                    ->
                    Toast.makeText(applicationContext, "please try again!", Toast.LENGTH_SHORT)
                        .show()
                }
                alertDialogBuilder.show()
            }
            }
        }

    }

    fun onClickEdtEmail(view: View) {
        infoViewModel.setEmail(binding.edtEmail.text.toString())
    }
    fun onClickEdtPassword(view: View) {
        infoViewModel.password.value = binding.edtPassword.text.toString()
    }

    private fun setupViewModel() {
        val account = Account("","","")
        viewModelFactory = MainViewModelFactory(account, "")
        infoViewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)
    }

    private fun setupObserver() {
        infoViewModel.account.observe(this, {
            binding.edtEmail.setText(it.email)
        })
        infoViewModel.password.observe(this, {
            binding.edtPassword.setText(it)
        })
    }
}
