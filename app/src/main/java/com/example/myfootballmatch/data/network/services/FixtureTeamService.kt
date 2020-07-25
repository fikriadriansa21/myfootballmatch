package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureTeamService {
    @GET("fixtures/team/{team_id}/last/10")
    fun getFixtureTeam(@Path("league_id") team_id: Int): Call<ApiFixture>
}