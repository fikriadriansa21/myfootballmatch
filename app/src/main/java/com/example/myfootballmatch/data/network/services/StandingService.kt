package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.standing.ApiStanding
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StandingService {
    @GET("leagueTable/{league_id}")
    fun getStandingData(@Path("league_id") league_id: Int): Call<ApiStanding>
}