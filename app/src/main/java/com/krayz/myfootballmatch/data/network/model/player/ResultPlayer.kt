package com.krayz.myfootballmatch.data.network.model.player

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultPlayer(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("players")
    val players: MutableList<Player>
) : Parcelable