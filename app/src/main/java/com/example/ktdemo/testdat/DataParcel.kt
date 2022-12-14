package com.example.ktdemo.testdat

import android.os.Parcel
import android.os.Parcelable

class DataParcel(var number: Int, var str1: String?, var str2: String?, var noSave: String? = "[不传送的字符串]") : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(str1)
        parcel.writeString(str2)
        parcel.writeString(noSave)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataParcel> {
        override fun createFromParcel(parcel: Parcel): DataParcel {
            return DataParcel(parcel)
        }

        override fun newArray(size: Int): Array<DataParcel?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {

        return "number: $number, str1: $str1, str2: $str2, noSave: $noSave"
    }


}