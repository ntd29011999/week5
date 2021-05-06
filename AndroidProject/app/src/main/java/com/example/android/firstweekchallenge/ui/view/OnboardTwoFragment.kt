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
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardTwoFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboard_two, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn1 = activity?.findViewById<ImageButton>(R.id.btn1)
        val vi1 = activity?.findViewById<View>(R.id.view1)
        val vi2 = activity?.findViewById<View>(R.id.view2)
        val t1 = activity?.findViewById<TextView>(R.id.textView4)
        val t2 = activity?.findViewById<TextView>(R.id.textView5)

        btn1?.setOnClickListener(){
            fragmentManager?.commit {
                setReorderingAllowed(true)
                // Replace whatever is in the fragment_container view with this fragment
                replace<OnboardThreeFragment>(R.id.frag)
            }
        }
    }

}