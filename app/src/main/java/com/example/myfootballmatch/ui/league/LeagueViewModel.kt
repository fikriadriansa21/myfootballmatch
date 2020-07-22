package com.example.myfootballmatch.ui.league


import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.ApiLeague
import com.example.myfootballmatch.data.network.model.League
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.network.NetworkConfig.leagueService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeagueViewModel(leagueService: LeagueService) : BaseViewModel(){

    private var league: MutableLiveData<List<League>>? = null
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        league = MutableLiveData()
        isLoading = MutableLiveData()
    }


    fun loadLeaguesNetwork() {
        setIsLoading(true)
        leagueService.getListDataLeague(2020)
            .enqueue(callback)
    }

    fun getLeagues(): MutableLiveData<List<League>>? {
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