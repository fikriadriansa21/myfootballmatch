package com.example.myfootballmatch.data.network.model.team

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @Expose
    @SerializedName("team_id")
    val team_id:Int,
    @Expose
    @SerializedName("name")
    val name:String,
    @Expose
    @SerializedName("logo")
    val logo:String
) : Parcelable