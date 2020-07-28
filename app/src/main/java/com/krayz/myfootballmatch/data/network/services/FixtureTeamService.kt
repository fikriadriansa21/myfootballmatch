package com.krayz.myfootballmatch.data.network.services

import com.krayz.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureTeamService {
    @GET("fixtures/team/{team_id}/last/10")
    fun getFixtureTeam(@Path("team_id") team_id: Int): Call<ApiFixture>
}