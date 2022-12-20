package com.example.ktdemo.thread

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class CorVm1 : ViewModel() {

    companion object {
        const val TAG = "rfDevCorVm1"
    }

    val info1LiveData: MutableLiveData<String> = MutableLiveData()
    fun cor1() {

        viewModelScope.launch {
            Log.d(TAG, "不指定dispatcher ${Thread.currentThread()}")
        }

    }

    fun ioCor(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "IO 协程 ${Thread.currentThread()}")
        }
    }

    fun mainCor() {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Main 协程 ${Thread.currentThread()}")
        }
    }

    fun defaultCor() {
        viewModelScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Default 协程 ${Thread.currentThread()}")
        }
    }

    fun unconfinedCor(){
        viewModelScope.launch(Dispatchers.Unconfined) {
            Log.d(TAG, "Unconfined 协程 ${Thread.currentThread()}")
        }
    }

    fun reqGet(){
        info1LiveData.value = "发起请求"
        viewModelScope.launch (Dispatchers.IO) {
            val url = URL("https://www.baidu.com/s?wd=abc")
            try {
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "GET"
                conn.connectTimeout = 10 * 1000
                conn.setRequestProperty("Cache-Control", "max-age=0")
                conn.doOutput = true
                val code = conn.responseCode

                if (code == 200) {
                    val baos = ByteArrayOutputStream()
                    val inputStream :InputStream = conn.inputStream
                    val inputs = ByteArray(1024)
                    var len: Int = 0
                    while (inputStream.read(inputs).also {
                        len = it
                        } > -1) {
                        baos.write(inputs, 0, len)
                    }
                    val content = String(baos.toByteArray())
                    baos.close()
                    inputStream.close()
                    conn.disconnect()
                    info1LiveData.postValue(content)
                    Log.d(TAG, "net1: $content")
                }else {
                    info1LiveData.postValue("网络请求出错 $conn")
                    Log.e(TAG, "net1: 网络请求出错 $conn")
                }
            }catch (e: java.lang.Exception){
                Log.e(TAG,"reqGet", e)

            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(TAG, "viewModel onCleared")
    }
}