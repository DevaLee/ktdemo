package com.example.ktdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.ktdemo.R

class ShowVersionDialog:DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var window = dialog?.window

       var root =   inflater.inflate(R.layout.show_version_dialog_con,container,false)
        var titleTv = root.findViewById<TextView>(R.id.title_tv)
        var tv1 = root.findViewById<TextView>(R.id.tv1)
        var tv2 = root.findViewById<TextView>(R.id.tv2)
        var bt = root.findViewById<Button>(R.id.confirm_btn)
        titleTv.text = "这里是标题"
        tv1.text = "这是内容1"
        tv2.text = "这是内容2"
        bt.setOnClickListener{
            println("点击了............")
        }
        return  root
    //
    //        return super.onCreateView(inflater, container, savedInstanceState)
    }
}