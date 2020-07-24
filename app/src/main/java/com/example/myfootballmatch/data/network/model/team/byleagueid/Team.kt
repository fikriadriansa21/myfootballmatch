package com.example.myfootballmatch.data.network.model.team.byleagueid

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @Expose
    @SerializedName("team_id")
    var team_id:Int?=null,
    @Expose
    @SerializedName("name")
    val name:String,
    @Expose
    @SerializedName("logo")
    val logo:String
) : Parcelable