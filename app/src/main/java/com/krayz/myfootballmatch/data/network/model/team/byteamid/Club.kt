package com.krayz.myfootballmatch.data.network.model.team.byteamid

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
    @Expose
    @SerializedName("team_id")
    var team_id:Int?=null,
    @Expose
    @SerializedName("name")
    val name:String,
    @Expose
    @SerializedName("logo")
    val logo:String,
    @Expose
    @SerializedName("venue_name")
    val stadium:String
) : Parcelable