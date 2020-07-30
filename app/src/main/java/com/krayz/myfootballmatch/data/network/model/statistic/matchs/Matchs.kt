package com.krayz.myfootballmatch.data.network.model.statistic.matchs

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.matchsPlayed.MatchsPlayed
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Matchs(
    @Expose
    @SerializedName("matchsPlayed")
    val matchsPlayed: MatchsPlayed,
    @Expose
    @SerializedName("wins")
    val wins: Wins,
    @Expose
    @SerializedName("draws")
    val draws: Draws,
    @Expose
    @SerializedName("loses")
    val loses: Loses
): Parcelable