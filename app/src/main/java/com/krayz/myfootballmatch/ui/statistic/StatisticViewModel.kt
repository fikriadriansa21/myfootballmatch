package com.krayz.myfootballmatch.ui.statistic

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.statistic.ApiStatistic
import com.krayz.myfootballmatch.data.network.model.statistic.Statistic
import com.krayz.myfootballmatch.data.network.services.StatisticService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatisticViewModel(private var statisticService: StatisticService) : BaseViewModel(){
    var statistics: MutableLiveData<Statistic> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadStatisticNetwork(idLeague: Int, idTeam: Int) {
        setIsLoading(true)
        statisticService.getStatisticData(idLeague,idTeam).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setStatistic(statistic: Statistic?) {
        setIsLoading(false)
        statistics.value = statistic
    }

    private var callback = object : Callback<ApiStatistic?> {
        override fun onResponse(@NonNull call: Call<ApiStatistic?>, @NonNull response: Response<ApiStatistic?>) {
            val statisticResult: ApiStatistic? = response.body()
            if (statisticResult != null) {
                setStatistic(statisticResult.api.statistics)
            } else {
                setStatistic(null)
            }
        }

        override fun onFailure(
            call: Call<ApiStatistic?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")
            setStatistic(null)
        }
    }

}