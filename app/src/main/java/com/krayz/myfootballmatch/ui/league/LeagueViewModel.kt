package com.krayz.myfootballmatch.ui.league


import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.league.ApiLeague
import com.krayz.myfootballmatch.data.network.model.league.League
import com.krayz.myfootballmatch.data.network.services.LeagueService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LeagueViewModel(private var leagueService: LeagueService) : BaseViewModel(){

    var league: MutableLiveData<List<League>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadLeaguesNetwork() {
        setIsLoading(true)
        leagueService.getListDataLeague(Calendar.getInstance().get(Calendar.YEAR)-1)
            .enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(leagues: List<League>) {
        setIsLoading(false)
        league.value=leagues
    }

    private var callback = object : Callback<ApiLeague>{
        override fun onResponse(@NonNull call: Call<ApiLeague?>, @NonNull response: Response<ApiLeague?>) {
            val leagueResult: ApiLeague? = response.body()
            if (leagueResult != null) {
                setLeagues(leagueResult.api.leagues)
            } else {
                setLeagues(emptyList<League>())
            }
        }

        override fun onFailure(
            call: Call<ApiLeague?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")
            setLeagues(emptyList<League>())
        }
    }

}