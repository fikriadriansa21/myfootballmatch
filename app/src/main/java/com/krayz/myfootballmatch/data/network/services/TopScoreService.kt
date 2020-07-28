package com.krayz.myfootballmatch.data.network.services

import com.krayz.myfootballmatch.data.network.model.topscore.ApiTopScorer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TopScoreService {
    @GET("topscorers/{league_id}")
    fun getFixtureFromTeamId(@Path("league_id") league_id: Int): Call<ApiTopScorer>
}