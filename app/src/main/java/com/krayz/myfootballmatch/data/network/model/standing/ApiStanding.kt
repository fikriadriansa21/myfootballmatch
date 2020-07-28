package com.krayz.myfootballmatch.data.network.model.standing

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiStanding(
    @Expose
    @SerializedName("api")
    val api: ResultStanding
): Parcelable