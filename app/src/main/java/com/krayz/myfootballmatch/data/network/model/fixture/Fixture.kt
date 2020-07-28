package com.krayz.myfootballmatch.data.network.model.fixture

import android.os.Parcelable
import com.krayz.myfootballmatch.data.network.model.fixture.away.AwayTeam
import com.krayz.myfootballmatch.data.network.model.fixture.home.HomeTeam
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fixture(
    @Expose
    @SerializedName("fixture_id")
    val fixture_id:Int,
    @Expose
    @SerializedName("event_date")
    val event_date:String,
    @Expose
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam,
    @Expose
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam,
    @Expose
    @SerializedName("goalsHomeTeam")
    val goalsHomeTeam: Int,
    @Expose
    @SerializedName("goalsAwayTeam")
    val goalsAwayTeam: Int
) : Parcelable