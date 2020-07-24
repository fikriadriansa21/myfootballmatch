package com.example.myfootballmatch.data.network.model.topscore

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultTopScorer(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("topscorers")
    val topScorers: List<TopScorer>
) : Parcelable