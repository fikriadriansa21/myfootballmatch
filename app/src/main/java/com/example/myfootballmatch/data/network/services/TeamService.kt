package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.team.byleagueid.ApiTeam
import com.example.myfootballmatch.data.network.model.team.byteamid.ApiClub
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamService {
    @GET("teams/team/{team_id}")
    fun getTeamId(@Path("team_id") team_id: Int): Call<ApiClub>

    @GET("teams/league/{league_id}")
    fun getTeamFromLeagueId(@Path("league_id") league_id: Int): Call<ApiTeam>
}