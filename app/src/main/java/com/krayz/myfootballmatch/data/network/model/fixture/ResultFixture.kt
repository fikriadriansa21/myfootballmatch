package com.krayz.myfootballmatch.data.network.model.fixture

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultFixture(
    @Expose
    @SerializedName("results")
    val results:Int,
    @Expose
    @SerializedName("fixtures")
    val fixtures: List<Fixture>
) : Parcelable