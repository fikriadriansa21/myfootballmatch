package com.example.myfootballmatch.data.network.model.topscore

import android.os.Parcelable
import com.example.myfootballmatch.data.network.model.topscore.Goals.Goals
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopScorer(
    @Expose
    @SerializedName("player_id")
    val player_id:Int,
    @Expose
    @SerializedName("player_name")
    val player_name:String,
    @Expose
    @SerializedName("team_name")
    val team_name:String,
    @Expose
    @SerializedName("goals")
    val goals: MutableList<Goals>
) : Parcelable