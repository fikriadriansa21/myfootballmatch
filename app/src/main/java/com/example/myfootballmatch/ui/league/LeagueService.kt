package com.example.myfootballmatch.ui.league

import com.example.myfootballmatch.data.network.model.ResultLeague
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueService {
    @GET("/seasons/{season}")
    fun getListDataLeague(@Path("season") season: Int): Call<Response<ResultLeague>>
}