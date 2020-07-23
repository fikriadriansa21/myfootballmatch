package com.example.myfootballmatch.data.network.services

import com.example.myfootballmatch.data.network.model.player.ApiPlayer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerService {
    @GET("/players/squad/{team_id}/{season}")
    fun getPlayerSquad(@Path("team_id") team_id: Int, @Path("season") season: String): Call<ApiPlayer>
}