package com.krayz.myfootballmatch.data.network.services

import com.krayz.myfootballmatch.data.network.model.standing.ApiStanding
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatisticService {
    @GET("statistics/{league_id}/{team_id}")
    fun getStandingData(@Path("league_id") league_id: Int, @Path("team_id") team_id: Int): Call<ApiStanding>
}