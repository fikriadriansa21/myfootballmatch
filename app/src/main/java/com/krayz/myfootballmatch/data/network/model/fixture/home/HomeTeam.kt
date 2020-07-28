package com.krayz.myfootballmatch.data.network.model.fixture.home

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeTeam(
    @Expose
    @SerializedName("team_id")
    val team_id:Int,
    @Expose
    @SerializedName("team_name")
    val team_name:String,
    @Expose
    @SerializedName("logo")
    val logo:String
) : Parcelable