package com.recyclerview.practise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.practise.R
import com.recyclerview.practise.model.Person

class PersonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var arrayList: List<Person> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        )
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

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)
        private val addressTextView = itemView.findViewById<TextView>(R.id.address_text_view)
        private val phoneTextView = itemView.findViewById<TextView>(R.id.phone_text_view)

        fun bind(model: Person) {
            nameTextView.text = model.name
            addressTextView.text = model.address
            phoneTextView.text = model.phone
        }
    }
}