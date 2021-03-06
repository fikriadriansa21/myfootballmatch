package com.krayz.myfootballmatch.data.network.model.standing

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultStanding(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("standings")
    val standings: List<List<Standing>>
) : Parcelable