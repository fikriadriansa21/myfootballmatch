package com.example.myfootballmatch.data.network.model.standing

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Standing(
    @Expose
    @SerializedName("rank")
    val rank:Int,
    @Expose
    @SerializedName("team_id")
    val team_id:Int,
    @Expose
    @SerializedName("teamName")
    val teamName:String,
    @Expose
    @SerializedName("logo")
    val logo:String,
    @Expose
    @SerializedName("all")
    val detail:DetailStanding,
    @Expose
    @SerializedName("points")
    val points:Int,
    @Expose
    @SerializedName("goalsDiff")
    val goalsDiff:Int

) : Parcelable