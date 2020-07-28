package com.krayz.myfootballmatch.data.network.model.fixture

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiFixture(
    @Expose
    @SerializedName("api")
    val api: ResultFixture
): Parcelable