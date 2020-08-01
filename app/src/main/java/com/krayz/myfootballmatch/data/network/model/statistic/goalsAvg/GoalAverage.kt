package com.krayz.myfootballmatch.data.network.model.statistic.goalsAvg

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalAverage(
    @Expose
    @SerializedName("goalsFor")
    val goalForAverage: GoalForAvg,
    @Expose
    @SerializedName("goalsAgainst")
    val goalAgainstAverage: GoalAgainstAvg
): Parcelable