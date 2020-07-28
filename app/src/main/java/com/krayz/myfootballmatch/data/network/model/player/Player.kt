package com.krayz.myfootballmatch.data.network.model.player

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @Expose
    @SerializedName("player_id")
    val player_id:Int,
    @Expose
    @SerializedName("player_name")
    val player_name:String,
    @Expose
    @SerializedName("position")
    val position:String
) : Parcelable