package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureService {
    @GET("fixtures/team/{team_id}")
    fun getFixtureFromTeamId(@Path("team_id") team_id: Int): Call<ApiFixture>


    @GET("fixtures/team/{team_id}/last/10")
    fun getFixtureFromTeamIdLast10(@Path("league_id") team_id: Int): Call<ApiFixture>

    @GET("fixtures/league/{league_id}/last/10")
    fun getFixtureFromLeagueIdLast10(@Path("league_id") league_id: Int): Call<ApiFixture>
}