package com.example.myfootballmatch.ui.league


import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.NetworkConfig.leagueService
import com.example.myfootballmatch.data.network.model.league.ApiLeague
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.ui.base.BaseViewModel
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

//    fun getLeagues(
//        pickLeagueRegisterActivity: PickLeagueRegisterActivity,
//        movieObserver: Observer<List<League?>?>
//    ): MutableLiveData<List<League>>? {
//        return league
//    }

    //    fun getLoadingStatus(): MutableLiveData<Boolean>? {
//        return isLoading
//    }
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
                Log.d("asdakasas","result tidak null")

                setLeagues(leagueResult.api.leagues)
                Log.d("asdakasas",leagueResult.api.leagues[0].name)
            } else {
                Log.d("asdakasas","result null")

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