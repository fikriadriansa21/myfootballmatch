package com.krayz.myfootballmatch.data.network.model.team.byleagueid

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultTeam(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("teams")
    val teams: List<Team>
) : Parcelable