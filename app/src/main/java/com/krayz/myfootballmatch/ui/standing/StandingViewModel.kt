package com.krayz.myfootballmatch.ui.standing

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.standing.ApiStanding
import com.krayz.myfootballmatch.data.network.model.standing.Standing
import com.krayz.myfootballmatch.data.network.services.StandingService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StandingViewModel(private var standingService: StandingService) : BaseViewModel(){

    var standings: MutableLiveData<List<List<Standing>>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadStandingNetwork(id: Int) {
        setIsLoading(true)
        standingService.getStanding(id).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setStanding(standing: List<List<Standing>>) {
        setIsLoading(false)
        standings.value = standing
    }

    private var callback = object : Callback<ApiStanding> {
        override fun onResponse(@NonNull call: Call<ApiStanding?>, @NonNull response: Response<ApiStanding?>) {
            val standingResult: ApiStanding? = response.body()
            if (standingResult != null) {
                setStanding(standingResult.api.standings)
            } else {
                setStanding(emptyList<List<Standing>>())
            }
        }

        override fun onFailure(
            call: Call<ApiStanding?>,
            t: Throwable
        ) {
            setStanding(emptyList<List<Standing>>())
        }
    }

}