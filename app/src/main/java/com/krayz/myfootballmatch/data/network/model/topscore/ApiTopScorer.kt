package com.krayz.myfootballmatch.data.network.model.topscore

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiTopScorer(
    @Expose
    @SerializedName("api")
    val api: ResultTopScorer
): Parcelable