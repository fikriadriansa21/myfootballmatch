package com.example.myfootballmatch.data.network.model.player

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiPlayer(
    @Expose
    @SerializedName("api")
    val api: ResultPlayer
): Parcelable