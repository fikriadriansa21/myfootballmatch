package com.example.myfootballmatch.data.network.model.standing

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailStanding(
    @Expose
    @SerializedName("matchsPlayed")
    val matchsPlayed: Int,
    @Expose
    @SerializedName("win")
    val win: Int,
    @Expose
    @SerializedName("draw")
    val draw: Int,
    @Expose
    @SerializedName("lose")
    val lose: Int,
    @Expose
    @SerializedName("goalsFor")
    val goalsFor: Int,
    @Expose
    @SerializedName("goalsAgainst")
    val goalsAgainst: Int
) : Parcelable