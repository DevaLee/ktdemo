package com.example.ktdemo

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktdemo.testdat.ItemData

class ItemRecycleTwo : AppCompatActivity() {

    private val mAdapter: ItemRecycleTwoAdapter = ItemRecycleTwoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_recycle_two)

        var recycleView = findViewById<RecyclerView>(R.id.recycleTwo)
        recycleView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)
        recycleView.adapter = mAdapter
        mAdapter.setDataList(genListData())
        recycleView.addItemDecoration(object :RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.top = 2
            }
        })
    }

    private fun genListData(): List<ItemData> {
        var datas = emptyList<ItemData>().toMutableList()
        for (i in 1..60) {
            var data = ItemData( "第${i}时区", number = i, i, i)
            datas.add(data)
        }
        return  datas
    }
}