package com.example.myfootballmatch.ui.standing

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.league.ApiLeague
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.model.standing.ApiStanding
import com.example.myfootballmatch.data.network.model.standing.Standing
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.data.network.services.StandingService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class StandingViewModel(private var standingService: StandingService) : BaseViewModel(){

    var standings: MutableLiveData<List<Standing>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadStandingNetwork() {
        setIsLoading(true)
        standingService.getStandingData(524).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(standing: List<Standing>) {
        setIsLoading(false)
        standings.value = standing
    }

    private var callback = object : Callback<ApiStanding> {
        override fun onResponse(@NonNull call: Call<ApiStanding?>, @NonNull response: Response<ApiStanding?>) {
            val standingResult: ApiStanding? = response.body()
            if (standingResult != null) {
                Log.d("asdakasas","result tidak null")

                setLeagues(standingResult.api.standings)
                Log.d("asdakasas",standingResult.api.standings[0].teamName)
            } else {
                Log.d("asdakasas","result null")

                setLeagues(emptyList<Standing>())
            }
        }

        override fun onFailure(
            call: Call<ApiStanding?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setLeagues(emptyList<Standing>())
        }
    }

}