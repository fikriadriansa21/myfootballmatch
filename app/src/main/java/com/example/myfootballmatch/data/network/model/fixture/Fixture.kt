package com.example.myfootballmatch.data.network.model.fixture

import android.os.Parcelable
import com.example.myfootballmatch.data.network.model.fixture.away.AwayTeam
import com.example.myfootballmatch.data.network.model.fixture.home.HomeTeam
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
    @SerializedName("home_team")
    val homeTeam: HomeTeam,
    @Expose
    @SerializedName("away_team")
    val awayTeam: AwayTeam,
    @Expose
    @SerializedName("goalsHomeTeam")
    val goalsHomeTeam: Int,
    @Expose
    @SerializedName("goalsHomeTeam")
    val goalsAwayTeam: Int
) : Parcelable