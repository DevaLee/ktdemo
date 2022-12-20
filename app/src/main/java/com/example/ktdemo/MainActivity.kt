package com.example.ktdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ktdemo.fragment.*
import com.example.ktdemo.multithread.MultiThread
import com.example.ktdemo.service.ServiceStartDemo
import com.example.ktdemo.testdat.DataParcel
import com.example.ktdemo.testdat.DataTestExamine
import com.example.ktdemo.thread.CorVm1
import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread


class MyLogger {
    var tag  = "TAG"

    fun e(msg: String) {
        println("$tag $msg")
    }

    fun tag(tagStr: String) {
        tag = tagStr
    }
}

class DbConfig {
    var url = ""
    var username = ""
    var password = ""

    override fun toString(): String {
        return "uri: $url, username: $username, password: $password"
    }
}

class DbConnection {
    fun config(config: DbConfig){
        println(config)
    }
}


class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "K_MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        "kotlin".also {
//            println("结果: ${it.plus("-java")}")
//        }.also {
//            println("结果：${it.plus("-php")}")
//        }

//
//        "kotlin".apply {
//            println("结果: ${this.plus("-java")}")
//        }.apply {
//            println("结果: ${this.plus("-php")}")
//        }

//        var btn = findViewById<Button>(R.id.button3)
//
//        btn.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                var height = btn.height
//                var width = btn.width
//
//                println("btn width: $width, height: $height")
//                btn.viewTreeObserver.removeOnGlobalLayoutListener(this)
//            }
//
//        });
//
//        btn.post(object : java.lang.Runnable{
//            override fun run() {
//                println("runnable width: ${btn.width}, height:${btn.height}")
//            }
//
//        })

//        editTextTest()
//        val textView = findViewById<TextView>(R.id.textView_tv)
//
//        textView.setOnTouchListener { p0, p1 ->
//            val downX = p1?.x
//            val downY = p1?.y
//
//            val rawX = p1?.rawX
//            val rawY = p1?.rawY
//
//            println("downX: $downX, downY: $downY, rawX:$rawX, rawY: $rawY")
//            false
//        }
//
//        textView.setOnClickListener {
//
//            println("on click listener")
//        }
//      btn.setOnTouchListener(object  :View.OnTouchListener {
//          @SuppressLint("ClickableViewAccessibility")
//          override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
//            val downX = p1?.x;
//              val downY = p1?.y
//            return false
//          }
//
//      })
//        val  conn = DbConnection()
//        conn.config(DbConfig().apply { url = "mysql:22:33:212:44"
//            username = "xu Tony"
//            password = "123111"
//        })

//        val logger = MyLogger()
//
//        with(logger)  {
//            tag("Kotlin")
//            e("It is a good language")
//        }
//        weightLight()
//        substractFun();

//        startService()
//        buildBlackRedDialog()
//        buildUConfirmDialog()
    }

    private fun editTextTest(){
        var editText = findViewById<EditText>(R.id.account_et)
        Log.d(TAG, ">>>>>>${editText.text}")
        editText.requestFocus()
        editText.setSelection(1)
        editText.setOnEditorActionListener { v, actionId, event ->
//            println("actionId: " + actionId)
//            println("event: " + event)
            Log.d(TAG, "actionId: " + actionId + " event: " + event)

            true
        }

    }

    private fun buildUConfirmDialog(){
        var dialog = UIConfirmDialog()
        dialog.title = "标题"
        dialog.confirmText = "确定"
        dialog.content = "欢迎来到安卓世界"
        dialog.showHeaderTv = true

        dialog?.show(supportFragmentManager, "ssss")
//        dialog.mDialogHeigh
    }

    private fun buildBlackRedDialog(){
        var dialog = BlackRedConfirmDialog.build("红和黑","这个是内容","取消","确认")
        dialog.show(supportFragmentManager, "SSDE")
    }



//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        var btn = findViewById<Button>(R.id.button3);
//        println("btn: width: ${btn.width}")
//
//        var displayMetrics  = resources.displayMetrics
//        println("screen width: ${displayMetrics.widthPixels}, height: ${displayMetrics.heightPixels}")
//
//        var  layoutParam = btn.layoutParams
//        layoutParam.width = 300
//        layoutParam.height = 100
//
//        btn.layoutParams = layoutParam
//
//
//
//    }
    private fun startService(){
        startService(Intent(applicationContext, ServiceStartDemo::class.java))
    }

    fun toNextActivity(view: View){

//        var intent = Intent(applicationContext, ForResultFirstAct::class.java)
//            startActivityForResult(intent, 10)

//        registerForActivityResult()

//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()
//        ) {
//            val data = it.data
//            val resultCode = it.resultCode
//        }.launch(intent)

//        startService()
//            popSimpleDialog1("title",   "contentssssssss")
//        showInputTextDialog(0, 500)
//        buildBlackRedDialog()
//        buildUConfirmDialog()
//        showVersionDialog()
//        checkUserPermission(applicationContext,"rust.permission.user.TEST")
//        toLayoutGuidePage()
//        toDrawerActivity()
//        toRecycleView()
//        multiThreadTest()
        viewModelScopeTest()
    }

    private fun viewModelScopeTest(){
        val cor = CorVm1()
//        cor.ioCor()
//        cor.mainCor()
//        cor.defaultCor()
//        cor.unconfinedCor()
        cor.reqGet()
    }

    fun multiThreadTest(){
        MultiThread.test1()
    }

    fun toRecycleView(){
        var intent = Intent(applicationContext, ItemRecycleTwo::class.java)
        startActivity(intent)
    }

    private fun toDrawerActivity(){
        var intent = Intent(applicationContext, DrawerDemoActivity::class.java)
        startActivity(intent)
    }

    private fun toLayoutGuidePage(){
        var intent = Intent(applicationContext, LayoutGuideLine::class.java)
        startActivity(intent)
    }

    fun checkUserPermission(context:Context, permissionName: String){
        var permission = packageManager.checkPermission(permissionName, packageName)
        var permissionTest = permission == PackageManager.PERMISSION_GRANTED
        Toast.makeText(context,if (permissionTest) "Test YES!" else "Test NO!", Toast.LENGTH_SHORT).show()

    }

    fun showVersionDialog(){
        var dialog = ShowVersionDialog()
        dialog.show(supportFragmentManager,"ssere")
    }

    private  fun showInputTextDialog(x: Int, y: Int) {
        var dialog = AdjustLocationDialog.newDialog(100, 1600)
//        var bundle = Bundle()
//        bundle.putInt(AdjustLocationDialog.K_X, 200)
//        bundle.putInt(AdjustLocationDialog.K_Y, 400)
//        dialog.arguments = bundle


        dialog.show(supportFragmentManager, "ss")

    }

    private fun popSimpleDialog1(title: String, content: String){
        var dialog = SimpleDialog()
        var bundle = Bundle()
        bundle.putString(SimpleDialog.K_TITLE, title)
        bundle.putString(SimpleDialog.K_CONTENT, content)
        dialog.arguments = bundle
        dialog.show(supportFragmentManager, "one-tag")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            10 -> {
                println("case 10")
                if (resultCode == RESULT_OK) {
                    println("RESULT_OK")
                    if (data != null) {
                       var title =  data.getStringExtra(ForResultFirstAct.K_TITLE)
                       var subTitle = data.getStringExtra(ForResultFirstAct.K_SUB_TITLE)

                        Toast.makeText(applicationContext, "title:$title, subtitle: $subTitle", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(applicationContext, "返回不成功", Toast.LENGTH_LONG).show()
                    }
                }
            }
            else -> {
                println("未识别")
            }
        }

        println("onActivityResult: ${requestCode}, $resultCode, $data")
    }

    fun toNext(){
        var intent = Intent(applicationContext, SendParamsDemo::class.java)
        intent.putExtra(SendParamsDemo.K_INT, 1)
        intent.putExtra(SendParamsDemo.K_BOOL, true)
        intent.putExtra(SendParamsDemo.k_STR, "eewwww")

        intent.putExtra(SendParamsDemo.K_INPUT_DATA, DataTestExamine(id = 89, name = "稽核看监控"))

        intent.putExtra(SendParamsDemo.K_Parcel_DATA, DataParcel(number = 10, str1 = "书后", str2 = "户籍", noSave = "878787hggh"))


        startActivity(intent)
    }



    fun weightLight(){

        runBlocking {
            for (t in 1..10000) {
                launch {
                    delay(500L * t)
//                    delay(t * 500)
                    println(".")
                }
            }
        }
    }



      fun waitCoroutineComplete(){
          runBlocking {
              var job1 = GlobalScope.launch {
                  println("job1 start")
                  delay(300)
                  println("job1 done")
              }
              var job2: Job = GlobalScope.launch {
                  println("job2 start")
                  delay(800)
                  println("job2 done")

              }

              job2.join();
              job1.join()

              println(">>>>>>>>> end")
          }
    }

    fun cnstructureConcurrancy(){
        runBlocking {
            println("主线程id: ${Thread.currentThread().id}")
            launch {
                println("协程1所在线程的id: ${Thread.currentThread().id}")
                delay(300)
                println("协程1执行完毕")
            }
            launch {
                println("协程2所在线程的id: ${Thread.currentThread().id}")
                delay(500)
                println("协程2执行完毕")
            }

            println("主线程执行完毕")
        }

    }


    fun scopeBuilder(){
        runBlocking {
            launch {
                delay(200)
                println("协程1 ${Thread.currentThread().id}")
            }

            coroutineScope {
                launch {
                    delay(500)
                    println("内部协程2-1 ${Thread.currentThread().id}")
                }
                delay(100)
                println("协程2 ${Thread.currentThread().id}")
            }
            println("主任务完毕")
        }
    }

    fun substractFun(){
        runBlocking {
            launch {
                r1()
            }
//            r1()
        }


    }
     suspend fun r1() {
        delay(300)
        println("提取出来的函数")
    }



}