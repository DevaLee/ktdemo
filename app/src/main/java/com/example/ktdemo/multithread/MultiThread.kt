package com.example.ktdemo.multithread

import android.util.Log
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MultiThread {

    companion object {
        val TAG = "2234"
        fun test1(){
            val tp: ExecutorService = Executors.newCachedThreadPool()

            val future = tp.submit(Callable {
                return@Callable "返回值 X"
            })
            Log.d(TAG, "future get之前 isDone: ${future.isDone}, isCancelled: ${future.isCancelled}")
            val res = future.get()

            Log.d(TAG, "future get之后 isDone: ${future.isDone}, isCancelled: ${future.isCancelled}")
            Log.d(TAG, "future get: $res")

        }

        fun invokeAllTest(){
            val tp: ExecutorService = Executors.newFixedThreadPool(5)
            val callList = arrayListOf<Callable<String>>(
                Callable {
                    Log.d(TAG, "task1 ${Thread.currentThread()}")
                    return@Callable "rust"
                },
                Callable {
                    Log.d(TAG, "task2 ${Thread.currentThread()}")
                    Thread.sleep(1500)
                    return@Callable "fisher"
                },
                Callable {

                    Log.d(TAG, "task3 ${Thread.currentThread()}")
                    return@Callable "列表里面的任务"
                }
            )
            Log.d(TAG, "invokeAll 准备提交任务")

            val futureList = tp.invokeAll(callList)
            Log.d(TAG, "invokeAll 已提交任务")
        }

    }

}