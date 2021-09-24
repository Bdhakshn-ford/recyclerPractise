package com.recyclerview.practise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.practise.R
import com.recyclerview.practise.databinding.ItemRecyclerViewBinding
import com.recyclerview.practise.model.Person

class PersonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var arrayList: List<Person> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PersonViewHolder -> {
                holder.bind(arrayList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class PersonViewHolder constructor(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(personModel: Person) {
            binding.model = personModel
        }
    }
}