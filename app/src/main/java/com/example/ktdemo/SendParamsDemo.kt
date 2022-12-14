package com.example.ktdemo

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ktdemo.testdat.DataParcel
import com.example.ktdemo.testdat.DataTestExamine

class SendParamsDemo : AppCompatActivity() {
    companion object {
        var K_INT :String = "k_int";
        var K_BOOL :String = "k_bool"
        var k_STR :String = "k_str"
        var K_INPUT_DATA :String = "K_INPUT_DATA"
        var K_Parcel_DATA :String = "K_Parcel_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_params_demo)
        gotInput()
    }

    fun gotInput(){
        var intent = intent;

        if (intent != null) {
            var i : Int = intent.getIntExtra(K_INT, -1)
            var b = intent.getBooleanExtra(K_BOOL, false)
            var str = intent.getStringExtra(k_STR,)


            var data: DataTestExamine =
                intent.getSerializableExtra(K_INPUT_DATA) as DataTestExamine;

            var paracel: DataParcel = intent.getParcelableExtra<DataParcel>(K_Parcel_DATA) as DataParcel




            println("got Input i: $i, b: $b, str: $str, data: $data, parcel: $paracel")
        }else {
            Log.d("1","intent == null")
        }

    }
}