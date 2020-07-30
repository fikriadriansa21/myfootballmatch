package com.krayz.myfootballmatch.data.network.model.statistic

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.krayz.myfootballmatch.data.network.model.statistic.goals.Goals
import com.krayz.myfootballmatch.data.network.model.statistic.goalsAvg.GoalAverage
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.Matchs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Statistic(
    @Expose
    @SerializedName("matchs")
    val matchs:Matchs,
    @Expose
    @SerializedName("goals")
    val goals: Goals,
    @Expose
    @SerializedName("goalsAvg")
    val goalsAverage: GoalAverage
) : Parcelable