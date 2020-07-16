package com.example.myfootballmatch.register.pickleagueregister

import com.example.myfootballmatch.register.pickleagueregister.model.ResultLeague
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueService {
    @GET("/seasons/{season}")
    fun getListDataLeague(@Path("season") season: Int): Call<List<ResultLeague>>
}