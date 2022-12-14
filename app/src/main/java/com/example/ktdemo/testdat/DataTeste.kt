package com.example.ktdemo.testdat

import android.os.Parcel
import android.os.Parcelable
import java.sql.RowId

public class DataTestExamine(var id: Int, var name: String) : java.io.Serializable{


    override fun toString(): String {
        return  "{id: $id, name: $name }"
    }
}