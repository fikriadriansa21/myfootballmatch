package com.example.myfootballmatch.ui.topscorer

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.topscore.ApiTopScorer
import com.example.myfootballmatch.data.network.model.topscore.TopScorer
import com.example.myfootballmatch.data.network.services.TopScoreService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopScorerViewModel(private var topScorerService: TopScoreService) : BaseViewModel(){

    var topScorers: MutableLiveData<List<TopScorer>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadTopScorerNetwork() {
        setIsLoading(true)
        topScorerService.getFixtureFromTeamId(524).enqueue(callback)
    }


    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(topScorer: List<TopScorer>) {
        setIsLoading(false)
        topScorers.value=topScorer
    }

    private var callback = object : Callback<ApiTopScorer> {
        override fun onResponse(@NonNull call: Call<ApiTopScorer?>, @NonNull response: Response<ApiTopScorer?>) {
            val topScorerResult: ApiTopScorer? = response.body()
            if (topScorerResult != null) {
                Log.d("asdakasas","result tidak null")

                setLeagues(topScorerResult.api.topScorers)
                Log.d("asdakasas",topScorerResult.api.topScorers[0].player_name)
            } else {
                Log.d("asdakasas","result null")

                setLeagues(emptyList<TopScorer>())
            }
        }

        override fun onFailure(
            call: Call<ApiTopScorer?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setLeagues(emptyList<TopScorer>())
        }
    }

}