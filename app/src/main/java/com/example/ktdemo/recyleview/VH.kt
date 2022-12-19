package com.example.ktdemo.recyleview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktdemo.R

class VH(itemView: View) :RecyclerView.ViewHolder(itemView) {
    lateinit var textView1: TextView;
    lateinit var textView2: TextView;

    init {
        textView1 = itemView.findViewById<TextView>(R.id.tv1)
        textView2 = itemView.findViewById<TextView>(R.id.tv2)
    }

}