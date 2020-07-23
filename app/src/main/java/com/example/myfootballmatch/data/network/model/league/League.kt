package com.example.myfootballmatch.data.network.model.league

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    @Expose
    @SerializedName("league_id")
    var league_id:Int?=null,
    @Expose
    @SerializedName("name")
    var name:String?="",
    @Expose
    @SerializedName("type")
    var type:String?="",
    @Expose
    @SerializedName("country")
    var country:String?="",
    @Expose
    @SerializedName("country_code")
    var country_code:String?="",
    @Expose
    @SerializedName("logo")
    var logo:String?="",
    @Expose
    @SerializedName("flag")
    var flag:String?=""
) : Parcelable