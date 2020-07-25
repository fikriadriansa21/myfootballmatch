package com.example.myfootballmatch.data.network.model.standing

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class All(
    @Expose
    @SerializedName("matchsPlayed")
    val matchsPlayed: Int? = null,
    @Expose
    @SerializedName("win")
    val win: Int? = null,
    @Expose
    @SerializedName("draw")
    val draw: Int? = null,
    @Expose
    @SerializedName("lose")
    val lose: Int? = null,
    @Expose
    @SerializedName("goalsFor")
    val goalsFor: Int? = null,
    @Expose
    @SerializedName("goalsAgainst")
    val goalsAgainst: Int? = null
) : Parcelable