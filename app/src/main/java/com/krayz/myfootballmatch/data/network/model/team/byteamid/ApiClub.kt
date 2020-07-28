package com.krayz.myfootballmatch.data.network.model.team.byteamid

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiClub(
    @Expose
    @SerializedName("api")
    val api: ResultClub
): Parcelable