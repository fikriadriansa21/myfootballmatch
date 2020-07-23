package com.example.myfootballmatch.data.network.model.league

import android.os.Parcelable
import com.example.myfootballmatch.data.network.model.league.League
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultLeague(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("leagues")
    val leagues: List<League>
) : Parcelable