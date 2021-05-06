package com.example.android.firstweekchallenge.ui.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.firstweekchallenge.R
import com.example.android.firstweekchallenge.data.RestaurantAdapter
import com.example.android.firstweekchallenge.data.getData
import com.example.android.firstweekchallenge.databinding.ActivityListrestaurantBinding
import com.example.android.firstweekchallenge.databinding.FragmentListRestaurantBinding
import com.example.android.firstweekchallenge.databinding.FragmentLoginBinding
import com.example.android.firstweekchallenge.ui.viewmodel.RestaurantViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ListRestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
lateinit var binding: FragmentListRestaurantBinding
class ListRestaurantFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewModel: RestaurantViewModel
    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListRestaurantBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        adapter = RestaurantAdapter()
        binding.rcList.layoutManager = LinearLayoutManager(activity)
        //binding.rcList.layoutManager = GridLayoutManager(this,2)
        binding.rcList.adapter = adapter
        adapter.submitList(getData())
    }

}