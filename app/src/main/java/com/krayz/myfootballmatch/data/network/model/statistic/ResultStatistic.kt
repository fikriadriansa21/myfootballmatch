package com.krayz.myfootballmatch.data.network.model.statistic

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultStatistic(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("statistics")
    val statistics: Statistic
) : Parcelable