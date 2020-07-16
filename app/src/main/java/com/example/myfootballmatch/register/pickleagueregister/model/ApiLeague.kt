package com.example.myfootballmatch.register.pickleagueregister.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiLeague(
    @Expose
    @SerializedName("api")
    val api: MutableList<ResultLeague>
):Parcelable