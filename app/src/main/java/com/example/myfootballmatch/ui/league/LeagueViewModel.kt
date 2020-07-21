package com.example.myfootballmatch.ui.league


import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.ui.base.BaseViewModel
import com.example.myfootballmatch.data.network.model.League
import com.example.myfootballmatch.data.network.model.ResultLeague
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeagueViewModel() : BaseViewModel(){

    private var league: MutableLiveData<List<League>>? = null
    private var isLoading: MutableLiveData<Boolean>? = null
    private lateinit var leagueService: LeagueService

    fun LeagueViewModel(leagueService: LeagueService) {
        this.leagueService = leagueService
        league = MutableLiveData()
        isLoading = MutableLiveData()
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(leagues: List<League>) {
        setIsLoading(false)
        league?.postValue(leagues)
    }

    private class MovieCallback : Callback<ResultLeague?> {
        override fun onResponse(@NonNull call: Call<ResultLeague?>, @NonNull response: Response<ResultLeague?>) {
            val leagueResult: ResultLeague? = response.body()
            if (leagueResult != null) {
                setLeagues(leagueResult.leagues)
            } else {
                setLeagues(emptyList<League>())
            }
        }

        override fun onFailure(
            call: Call<ResultLeague?>,
            t: Throwable
        ) {
            setLeagues(emptyList<League>())
        }
    }
}