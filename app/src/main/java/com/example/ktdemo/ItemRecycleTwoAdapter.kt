package com.example.ktdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktdemo.testdat.ItemData

class ItemRecycleTwoAdapter: RecyclerView.Adapter<ItemRecycleTwoVH>() {
    private var dataList: List<ItemData> = emptyList<ItemData>();


    fun setDataList(listData: List<ItemData>){
        dataList = listData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRecycleTwoVH {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle_two, parent,false)
       return ItemRecycleTwoVH(view)
    //        return ItemRecycleTwoVH();
    }

    override fun onBindViewHolder(holder: ItemRecycleTwoVH, position: Int) {
        var itemData = dataList.get(position)
        holder.tv1?.text = itemData.timeZone;
        holder.tv2?.text = "${itemData.count}"
        holder.tv3?.text = "${itemData.number}"
        holder.tv4?.text = "${itemData.personCount}"
    }

    override fun getItemCount(): Int {
        return  dataList.count()
    }
}