package com.krayz.myfootballmatch.ui.topscorer

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.topscore.ApiTopScorer
import com.krayz.myfootballmatch.data.network.model.topscore.TopScorer
import com.krayz.myfootballmatch.data.network.services.TopScoreService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopScorerViewModel(private var topScorerService: TopScoreService) : BaseViewModel(){

    var topScorers: MutableLiveData<List<TopScorer>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadTopScorerNetwork(id: Int) {
        setIsLoading(true)
        topScorerService.getFixtureFromTeamId(id).enqueue(callback)
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
                setLeagues(topScorerResult.api.topScorers)
            } else {
                setLeagues(emptyList<TopScorer>())
            }
        }

        override fun onFailure(
            call: Call<ApiTopScorer?>,
            t: Throwable
        ) {

            setLeagues(emptyList<TopScorer>())
        }
    }

}