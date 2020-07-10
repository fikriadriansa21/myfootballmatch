package com.example.myfootballmatch.country.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    @Expose
    @SerializedName("country")
    val country: String,
    @Expose
    @SerializedName("flag")
    val flag: String
) : Parcelable