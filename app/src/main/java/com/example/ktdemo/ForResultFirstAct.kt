package com.example.ktdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ForResultFirstAct : AppCompatActivity() {

    companion object {
        var K_TITLE = "k_title"
        var K_SUB_TITLE = "k_sub_title"
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result_first)
    }

    override fun onBackPressed() {
//        super.onBackPressed()

        var resultIntent = Intent()
        resultIntent.putExtra(K_TITLE, "标题")
        resultIntent.putExtra(K_SUB_TITLE, "副标题")
        setResult(RESULT_OK, resultIntent)

        finish()


        println(">>>>>>>>>>>> on Back")

    }
}