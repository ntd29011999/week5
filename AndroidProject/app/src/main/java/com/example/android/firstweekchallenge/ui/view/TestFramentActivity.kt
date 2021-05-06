package com.example.android.firstweekchallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.firstweekchallenge.R

class TestFramentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_frament)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<OnboardOneFragment>(R.id.frag)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_list_opt->{
                Toast.makeText(this,"ListView Selected", Toast.LENGTH_SHORT).show()
                binding.rcList.layoutManager = LinearLayoutManager(this)
            }
            R.id.nav_grid_opt->{
                Toast.makeText(this,"GridView Selected", Toast.LENGTH_SHORT).show()
                binding.rcList.layoutManager = GridLayoutManager(this,2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}