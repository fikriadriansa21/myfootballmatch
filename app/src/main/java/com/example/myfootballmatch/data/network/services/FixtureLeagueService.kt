package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureLeagueService {
    @GET("fixtures/league/{league_id}/last/10")
    fun getFixtureLeague(@Path("league_id") league_id: Int): Call<ApiFixture>
}