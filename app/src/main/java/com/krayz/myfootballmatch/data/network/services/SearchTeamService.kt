package com.krayz.myfootballmatch.data.network.services

import com.krayz.myfootballmatch.data.network.model.team.byleagueid.ApiTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchTeamService {
    @GET("teams/search/{keyWord}")
    fun getSearchData(@Path("keyWord") keyword: String): Call<ApiTeam>
}