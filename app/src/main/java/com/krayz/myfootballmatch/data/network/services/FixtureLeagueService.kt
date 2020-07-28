package com.krayz.myfootballmatch.data.network.services

import com.krayz.myfootballmatch.data.network.model.fixture.ApiFixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureLeagueService {
    @GET("fixtures/league/{league_id}/last/5")
    fun getFixtureLeague(@Path("league_id") league_id: Int): Call<ApiFixture>
}