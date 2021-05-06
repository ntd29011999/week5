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
import com.example.android.firstweekchallenge.databinding.FragmentLoginBinding
import com.example.android.firstweekchallenge.databinding.FragmentSignUpBinding
import com.example.android.firstweekchallenge.ui.viewmodel.InfoViewModel
import com.example.android.firstweekchallenge.ui.viewmodel.MainViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setupViewModel()
        // Inflate the layout for this fragment
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnSignUp.setOnClickListener {

                //Check validation the filled information
                var invalidFlag:Boolean = false;
                val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}".toRegex();
                val passwordPattern1 = "[a-z]{8,32}".toRegex()
                val passwordPattern2 = "[!|@|#|$|%|^|&|*|(|)|-|_|+|=]".toRegex()
                val passwordPattern3 = "[A-Z]".toRegex()
                val passwordPattern4 = "[0-9]".toRegex()
                if(emailPattern.matches(edtEmail.text.trim().toString())){
                    invalidFlag = false;
                }

                else {
                    edtEmail.setError("The email is invalid");
                    invalidFlag = true;
                }

                if(passwordPattern1.containsMatchIn(edtPassword.text.trim().toString())
                    &&passwordPattern2.containsMatchIn(edtPassword.text.trim().toString())
                    &&passwordPattern3.containsMatchIn(edtPassword.text.trim().toString())
                    &&passwordPattern4.containsMatchIn(edtPassword.text.trim().toString())){
                    invalidFlag = false;
                }
                else{
                    edtPassword.setError("The password is invalid");
                    invalidFlag = true;
                }

                if (edtFullName.text.trim().toString().isNullOrEmpty()) {
                    edtFullName.setError("enter full name please!");
                }
                if (edtEmail.text.trim().toString().isNullOrEmpty()) {
                    edtEmail.setError("enter email please!");
                }
                if (edtPassword.text.trim().toString().isNullOrEmpty()) {
                    edtPassword.setError("enter password please!");
                }

                if (edtFullName.text.trim().toString() != "" && edtEmail.text.trim().toString() != "" && edtPassword.text.trim().toString() != "" && invalidFlag == false){

                    DataStore.fullName = edtFullName.text.trim().toString()
                    DataStore.email = edtEmail.text.trim().toString()
                    DataStore.password = edtPassword.text.trim().toString()
                    Toast.makeText(activity, "successful sign up!", Toast.LENGTH_SHORT).show()
                    // Login Fragment
                    var fr = getFragmentManager()?.beginTransaction()
                    fragmentManager?.commit {
                        setReorderingAllowed(true)
                        // Replace whatever is in the fragment_container view with this fragment
                        replace<LoginFragment>(R.id.frag)
                        addToBackStack(null)
                    }
                    //finish()
                }else{
                    val alertDialogBuilder = android.app.AlertDialog.Builder(activity)
                    alertDialogBuilder.setMessage("failed sign up!")
                    alertDialogBuilder.setPositiveButton("OK") { dialog: DialogInterface,
                                                                 which: Int ->
                        Toast.makeText(activity, "please try again!", Toast.LENGTH_SHORT).show()
                    }
                    alertDialogBuilder.show()
                }
            }}
    }


    fun onClickEdtEmail(view: View) {
        infoViewModel.setEmail(binding.edtEmail.text.toString())
    }
    fun onClickEdtFullName(view: View) {
        infoViewModel.setFullName(binding.edtFullName.text.toString())

    }
    fun onClickEdtPassword(view: View) {
        infoViewModel.password.value = binding.edtPassword.text.toString()
    }

    private fun setupViewModel() {
        val account = Account("","","")
        viewModelFactory = MainViewModelFactory(account, "")
        infoViewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)

    }
}