package com.example.myfootballmatch.data.network.model.topscore.Goals

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Goals(
    @Expose
    @SerializedName("total")
    val total:Int
) : Parcelable