package com.yut3.testdatabinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yut3.testdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        setContentView(binding.root)


        val list = ArrayList<MyData>()
        for (i in 0..99) {
            list.add(MyData(i, i + 100, i.toString()))
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        val adapter = MyAdapter(list)
        binding.recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onClick(view: View, data: MyData) {
                Toast.makeText(applicationContext, data.name, Toast.LENGTH_LONG).show()
            }
        })
    }
}
