package com.example.ktdemo


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemRecycleTwoVH (var itemView :View): RecyclerView.ViewHolder(itemView) {
    var tv1: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var tv4: TextView? = null



    init {
        tv1 = itemView.findViewById<TextView>(R.id.tv1)
        tv2 = itemView.findViewById<TextView>(R.id.tv2)
        tv3 = itemView.findViewById<TextView>(R.id.tv3)
        tv4 = itemView.findViewById<TextView>(R.id.tv4)
    }

}