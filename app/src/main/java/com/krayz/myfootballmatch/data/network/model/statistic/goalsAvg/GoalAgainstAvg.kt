package com.krayz.myfootballmatch.data.network.model.statistic.goalsAvg

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalAgainstAvg(
    @Expose
    @SerializedName("home")
    val home: Double,
    @Expose
    @SerializedName("away")
    val away: Double,
    @Expose
    @SerializedName("total")
    val total: Double
): Parcelable