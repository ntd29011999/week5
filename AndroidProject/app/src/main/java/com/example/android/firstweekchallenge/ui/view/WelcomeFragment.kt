package com.example.android.firstweekchallenge.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.android.firstweekchallenge.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textDescription1 = activity?.findViewById<TextView>(R.id.tvWelcomeTo)
        val textDescription2 = activity?.findViewById<TextView>(R.id.tvFoodHub)
        val textDescription3 = activity?.findViewById<TextView>(R.id.tvSlogan)
        val epButton = activity?.findViewById<Button>(R.id.epButton)
        val fbButton = activity?.findViewById<Button>(R.id.fbButton)
        val ggButton = activity?.findViewById<Button>(R.id.ggButton)
        val signInButton = activity?.findViewById<ImageButton>(R.id.signInButton)

        //val textDescription4 = findViewById<TextView>(R.id.tvQuestion)


        epButton?.setOnClickListener {
            fragmentManager?.commit {
                setReorderingAllowed(true)
                // Replace whatever is in the fragment_container view with this fragment
                replace<LoginFragment>(R.id.frag)
                addToBackStack(null)
            }
        }
    }

}