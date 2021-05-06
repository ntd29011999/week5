package com.example.android.firstweekchallenge.ui.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.example.android.firstweekchallenge.R
import com.example.android.firstweekchallenge.data.Account
import com.example.android.firstweekchallenge.data.DataStore
import com.example.android.firstweekchallenge.databinding.ActivityLoginBinding
import com.example.android.firstweekchallenge.databinding.FragmentLoginBinding
import com.example.android.firstweekchallenge.ui.viewmodel.InfoViewModel
import com.example.android.firstweekchallenge.ui.viewmodel.MainViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentLoginBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intentSignUpActivity = Intent(activity, SignUpActivity::class.java)
        val intentListRestaurantActivity = Intent(activity, ListRestaurantActivity::class.java)
        setupViewModel()
        binding.btnSignUp.setOnClickListener {
            // chay frament khac
            fragmentManager?.commit {
                setReorderingAllowed(true)
                // Replace whatever is in the fragment_container view with this fragment
                replace<SignUpFragment>(R.id.frag)
                addToBackStack(null)
            }
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
                // chay fragment khac
                Toast.makeText(activity, "successful login!", Toast.LENGTH_SHORT).show()
                fragmentManager?.commit {
                    setReorderingAllowed(true)
                    // Replace whatever is in the fragment_container view with this fragment
                    replace<ListRestaurantFragment>(R.id.frag)
                    addToBackStack(null)
                }
                //finish()
            } else {
                val alertDialogBuilder = android.app.AlertDialog.Builder(activity)
                alertDialogBuilder.setMessage("failed login!")
                alertDialogBuilder.setPositiveButton("OK") {
                        dialog: DialogInterface,
                        which: Int
                    ->
                    Toast.makeText(activity, "please try again!", Toast.LENGTH_SHORT)
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

//    private fun setupObserver() {
//        infoViewModel.account.observe(activity, {
//            binding.edtEmail.setText(it.email)
//        })
//        infoViewModel.password.observe(this, {
//            binding.edtPassword.setText(it)
//        })
//    }
}