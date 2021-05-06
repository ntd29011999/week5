package com.example.android.firstweekchallenge.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.android.firstweekchallenge.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardOneFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboard_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn = activity?.findViewById<ImageButton>(R.id.btn1)
        val v1 = activity?.findViewById<View>(R.id.view1)
        val v2 = activity?.findViewById<View>(R.id.view2)
        val text1 = activity?.findViewById<TextView>(R.id.textView4)
        val text2 = activity?.findViewById<TextView>(R.id.textView5)

        btn?.setOnClickListener(){
            fragmentManager?.commit {
                setReorderingAllowed(true)
                // Replace whatever is in the fragment_container view with this fragment
                replace<LoginFragment>(R.id.frag)
                addToBackStack(null)
            }
        }
    }
}