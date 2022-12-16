package com.example.ktdemo.fragment

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.ktdemo.R

//abstract class OnItemTapListener {
//    fun onConfirm()
//}

interface OnItemTapListener {
   fun onConfirm()
   fun onCancel()
}

class BlackRedConfirmDialog: DialogFragment() {
    companion object {
        val F_TAG = "f_tag_confirm_dialog"

        fun build(title: String, content: String, cancelText: String, confirmText:String): BlackRedConfirmDialog {
            var d = BlackRedConfirmDialog()
            d.mTitle = title;
            d.mConfirmText = confirmText
            d.mContent = content
            d.mCancelText = cancelText

            return  d
        }

    }

    private var mDialogWidth = -1
    private var mDialogHeight = -1
    private var mContent = ""
    private var mTitle = ""
    private var mCancelText = "Cancel"
    private var mConfirmText = "Confirm"
    private var _onItemClickListener: OnItemTapListener? = null
    fun setOnItemClickListener(onItemClickListener: OnItemTapListener) {
        _onItemClickListener = onItemClickListener
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStart() {
        super.onStart()
        var window = dialog?.window
        var params = window?.attributes
        params?.dimAmount = 0f
        window?.attributes = params

//        var dm = DisplayMetrics()
        var dm = resources?.displayMetrics
        if (mDialogWidth < 0) {
            mDialogWidth =  ((dm?.widthPixels ?: 0) * 0.55).toInt()
            mDialogHeight = ((dm?.heightPixels ?: 0) * 0.5).toInt()
        }

        println("mDialogWidth: $mDialogWidth, mDialogHeight: $mDialogHeight")
        window?.setLayout(mDialogWidth, mDialogHeight)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var window = dialog?.window
        if (window != null){
            window.requestFeature(Window.FEATURE_NO_TITLE)
        }
        var root = inflater.inflate(R.layout.dialog_yes, container,false)
        var confirmTv = root.findViewById<TextView>(R.id.confirm_tv)
        var contentTv = root.findViewById<TextView>(R.id.content_tv)
        var titleTv = root.findViewById<TextView>(R.id.title_tv)
        var cancelTv = root.findViewById<TextView>(R.id.cancel_tv)

        confirmTv.text = mConfirmText
        contentTv.text = mContent
        titleTv.text = mTitle
        cancelTv.text = mCancelText

        confirmTv.setOnClickListener {
            _onItemClickListener?.onConfirm()
        }

        cancelTv.setOnClickListener {
            _onItemClickListener?.onCancel()
        }

        return root
    }

}