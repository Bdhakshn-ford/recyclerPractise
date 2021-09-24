package com.recyclerview.practise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.practise.R
import com.recyclerview.practise.model.RecyclerModel

class TrainLineAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var arrayList: List<RecyclerModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CustomViewHolder -> {
                holder.bind(arrayList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)
        private val addressTextView = itemView.findViewById<TextView>(R.id.address_text_view)
        private val phoneTextView = itemView.findViewById<TextView>(R.id.phone_text_view)

        fun bind(model: RecyclerModel) {
            nameTextView.text = model.name
            addressTextView.text = model.address
            phoneTextView.text = model.phone
        }
    }
}