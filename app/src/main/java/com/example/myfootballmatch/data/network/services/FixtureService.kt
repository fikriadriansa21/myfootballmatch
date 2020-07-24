package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureService {
    @GET("/fixtures/team/{team_id}")
    fun getFixtureFromTeamId(@Path("team_id") team_id: Int): Call<ApiFixture>


    @GET("/fixtures/league/{league_id}/{date}")
    fun getFixtureFromLeagueId(@Path("league_id") league_id: Int, @Path("date") date: String): Call<ApiFixture>
}