package com.example.myfootballmatch.data.network.model.team

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiTeam(
    @Expose
    @SerializedName("api")
    val api: ResultTeam
): Parcelable