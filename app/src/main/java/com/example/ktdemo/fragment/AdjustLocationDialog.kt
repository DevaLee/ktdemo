package com.example.ktdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.ktdemo.R

class AdjustLocationDialog(): DialogFragment() {

    companion object {
        val TAG = "rustAppDialog"
        val  K_X = "k_x"
        val  K_Y = "k_y"

        fun newDialog(x: Int, y: Int) : AdjustLocationDialog {
            val dialog = AdjustLocationDialog()
            val bundle = Bundle()
            bundle.putInt(K_X, x)
            bundle.putInt(K_Y, y)
            dialog.arguments = bundle

            return dialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: " + arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogWindow = dialog?.window
        val lp = dialogWindow?.attributes
        dialogWindow?.setGravity(Gravity.TOP or Gravity.START)
        dialogWindow?.setBackgroundDrawableResource(android.R.color.holo_red_dark)
        dialogWindow?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        lp?.width = WindowManager.LayoutParams.WRAP_CONTENT

        var bundle = arguments

        lp?.x = bundle?.getInt(K_X)
        lp?.y = bundle?.getInt(K_Y)
        Log.d(TAG, "onCreteView: y == " + lp?.y)
        dialogWindow?.attributes =  lp

        return  inflater.inflate(R.layout.dialog_input_text, container, false)
//        return  inflater.inflate()
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}