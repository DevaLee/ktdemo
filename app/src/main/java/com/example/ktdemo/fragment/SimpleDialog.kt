package com.example.ktdemo.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ktdemo.R

class SimpleDialog :DialogFragment() {

    companion object {
        var K_TITLE = "k_title"
        var K_CONTENT = "k_content"
    }

    var title = ""
    var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            title = arguments?.getString(K_TITLE) ?: ""
            content = arguments?.getString(K_CONTENT) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        super.onCreateView(inflater, container, savedInstanceState)

        var dialogWindow = dialog?.window;

        dialogWindow?.setBackgroundDrawableResource(android.R.color.transparent)
        dialogWindow?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return inflater.inflate(R.layout.dialog_simple, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var  titleTv = view.findViewById<TextView>(R.id.title_tv)
        var contentTv = view.findViewById<TextView>(R.id.content_tv)

        titleTv.text = title
        contentTv.text = content


    }

}