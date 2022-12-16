package com.example.ktdemo.fragment

import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ktdemo.R


interface OnItemClickerListener {
    fun onConfirm()
    fun onCancel()
}

class UIConfirmDialog: DialogFragment() {

    companion object {
        val F_TAG:String = "f_tag_confirm_dialog"

    }

    var mDialogWidth = -1
    var mDialogHeight = -1
    var showHeaderTv = false
    var showTitleTv = false
    var headerResId = -1
    var contentResId = -1
    var confirmTextId = -1
    var titleTextResId = -1
    var content = ""
    var title = ""
    var confirmText = ""

    private var _onItemClickListener: OnItemTapListener? = null

    fun setOnItemClickListener(listener: OnItemTapListener) {
        _onItemClickListener = listener
    }

    override fun onStart() {
        super.onStart()
        var window = dialog?.window
        var attributes = window?.attributes
        attributes?.dimAmount = 0f
        if (window != null) {
            window.attributes = attributes
        }

        var dm = resources.displayMetrics
        if(mDialogWidth < 0){
            mDialogWidth = (dm.widthPixels * 0.68).toInt()
            mDialogHeight = (dm.heightPixels * 0.65).toInt()
        }
        window?.setLayout(mDialogWidth, mDialogHeight)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var window = dialog?.window
        if (window != null) {
            window?.requestFeature(Window.FEATURE_NO_TITLE)
        }

        val root = inflater?.inflate(R.layout.dialog_u_confirm, container,false)
        val title_tv = root?.findViewById<TextView>(R.id.title_tv)
        val content_tv = root?.findViewById<TextView>(R.id.content_tv)
        val confirm = root?.findViewById<TextView>(R.id.confirm_tv)
        val headerIv = root?.findViewById<ImageView>(R.id.header_iv)
        val close_v = root?.findViewById<View>(R.id.close_iv)
        if(contentResId > 0 && TextUtils.isEmpty(content)) {
            content_tv?.setText(contentResId)
        }else {
            content_tv?.text = content
        }

        if(confirmTextId > 0){
            confirm?.setText(confirmTextId)
        }else {
            confirm?.text = confirmText
        }

        confirm?.setOnClickListener{
            _onItemClickListener?.onConfirm()
        }

        close_v?.setOnClickListener{
            _onItemClickListener?.onCancel()
        }

        if (titleTextResId > 0 && TextUtils.isEmpty(title)) {
            title_tv?.setText(titleTextResId)
        }else{
            title_tv?.text = title
        }

        title_tv?.visibility = if(showTitleTv) View.VISIBLE else View.GONE

        if (showHeaderTv) {
            headerIv?.setImageResource(headerResId)
            headerIv?.visibility = View.VISIBLE
        }else {
            headerIv?.visibility = View.GONE
        }

        return root
    }

}