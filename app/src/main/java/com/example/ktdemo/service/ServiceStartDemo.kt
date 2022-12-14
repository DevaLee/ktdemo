package com.example.ktdemo.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceStartDemo: Service() {
    companion object {
        const val TAG = "rustAppStartDemoService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate ${Thread.currentThread()}")
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG, "onBind ${Thread.currentThread()}")

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand ${Thread.currentThread()} flags: ${flags}, startId: $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {

        Log.d(TAG, "onDestroy ")
        super.onDestroy()
    }

}