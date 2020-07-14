package com.example.myfootballmatch.register.pickleagueregister.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    @Expose
    @SerializedName("league_id")
    val league_id:Int,
    @Expose
    @SerializedName("name")
    val name:String,
    @Expose
    @SerializedName("type")
    val type:String,
    @Expose
    @SerializedName("country")
    val country:String,
    @Expose
    @SerializedName("country_code")
    val country_code:String,
    @Expose
    @SerializedName("logo")
    val logo:String,
    @Expose
    @SerializedName("flag")
    val flag:String
) : Parcelable