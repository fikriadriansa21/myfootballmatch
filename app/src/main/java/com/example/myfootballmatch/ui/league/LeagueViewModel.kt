package com.example.myfootballmatch.ui.league


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

class LeagueViewModel(leagueService: LeagueService) : BaseViewModel(){

    private var league: MutableLiveData<List<League>>? = null
    private var isLoading: MutableLiveData<Boolean>? = null

//    private var leagueService: LeagueService? = null

    init {
        NetworkConfig.leagueService = leagueService
        league = MutableLiveData()
        isLoading = MutableLiveData()
    }


    fun loadLeaguesNetwork() {
        setIsLoading(true)
        leagueService?.getListDataLeague(Calendar.getInstance().get(Calendar.YEAR))
            ?.enqueue(callback)
    }

    fun getLeagues(
        pickLeagueRegisterActivity: PickLeagueRegisterActivity,
        movieObserver: Observer<List<League?>?>
    ): MutableLiveData<List<League>>? {
        return league
    }

    fun getLoadingStatus(): MutableLiveData<Boolean>? {
        return isLoading
    }
    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(leagues: List<League>) {
        setIsLoading(false)
        league?.postValue(leagues)
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
            setLeagues(emptyList<League>())
        }
    }


//    private class LeagueCallback : Callback<ResultLeague?> {
//        override fun onResponse(@NonNull call: Call<ResultLeague?>, @NonNull response: Response<ResultLeague?>) {
//            val leagueResult: ResultLeague? = response.body()
//            if (leagueResult != null) {
//                setLeagues(leagueResult.leagues)
//            } else {
//                setLeagues(emptyList<League>())
//            }
//        }
//
//        override fun onFailure(
//            call: Call<ResultLeague?>,
//            t: Throwable
//        ) {
//            setLeagues(emptyList<League>())
//        }
//    }
}