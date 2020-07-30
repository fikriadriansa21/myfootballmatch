package com.krayz.myfootballmatch.data.network.model.statistic.matchs

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Draws(
    @Expose
    @SerializedName("home")
    val home: Int,
    @Expose
    @SerializedName("away")
    val away: Int,
    @Expose
    @SerializedName("total")
    val total: Int
): Parcelable