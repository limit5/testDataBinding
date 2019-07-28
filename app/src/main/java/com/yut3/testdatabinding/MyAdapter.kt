package com.yut3.testdatabinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yut3.testdatabinding.databinding.ItemViewBinding

class MyAdapter(var dataList: List<MyData>) : RecyclerView.Adapter<MyAdapter.BindingHolder>() {
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        setOnItemClickListener(listener)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val data = dataList[position]
        holder.binding.data = data
        holder.binding.originalLinearLayout.setOnClickListener {
            listener.onClick(it, data)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickListener {
        fun onClick(view: View, data: MyData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class BindingHolder(var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}