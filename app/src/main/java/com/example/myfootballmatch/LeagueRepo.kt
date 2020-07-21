package com.example.myfootballmatch

import com.example.myfootballmatch.ui.base.BaseRepository
import com.example.myfootballmatch.ui.league.LeagueService
import com.example.myfootballmatch.data.network.model.League
import retrofit2.await

class LeagueRepo(private val apiInterface: LeagueService) : BaseRepository() {

    suspend fun getSeasonsLeague() :  MutableList<League>?{
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.getListDataLeague(2020).await()},
            error = "Error fetching data league"
            //convert to mutable list
        )?.leagues?.toMutableList()
    }
}