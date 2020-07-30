package com.krayz.myfootballmatch.data.network.model.statistic.goals

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Goals(
    @Expose
    @SerializedName("goalsFor")
    val goalForGoals: GoalForGoals,
    @Expose
    @SerializedName("goalsAgainst")
    val goalAgainstGoals: GoalAgainstGoals
): Parcelable