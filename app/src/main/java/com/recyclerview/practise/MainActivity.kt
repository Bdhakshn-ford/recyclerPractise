package com.recyclerview.practise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.practise.adapter.PersonAdapter
import com.recyclerview.practise.viewModel.MainViewModel
import com.recyclerview.practise.viewModel.PersonDetailsRepository

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel =
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    private val recyclerViewAdapter = PersonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.csvRecyclerView)
        viewModel.personDetailsRepository = PersonDetailsRepository(resources)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = recyclerViewAdapter
        viewModel.readData()
        viewModel.recyclerData.observe(this, Observer {
            recyclerViewAdapter.arrayList = it
        })

        viewModel.showError.observe(this, Observer {
            if (it) {
                Toast.makeText(this.applicationContext, "Error Reading File", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}