package com.krayz.myfootballmatch.ui.search

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.team.byleagueid.ApiTeam
import com.krayz.myfootballmatch.data.network.model.team.byleagueid.Team
import com.krayz.myfootballmatch.data.network.services.SearchTeamService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel(private var searchTeamService: SearchTeamService) : BaseViewModel(){

    var team: MutableLiveData<List<Team>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadSearchTeam(keyWord: String) {
        setIsLoading(true)
        searchTeamService.getSearchData(keyWord).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(teams: List<Team>) {
        setIsLoading(false)
        team.value=teams
    }

    private var callback = object : Callback<ApiTeam> {
        override fun onResponse(@NonNull call: Call<ApiTeam?>, @NonNull response: Response<ApiTeam?>) {
            val teamResult: ApiTeam? = response.body()
            if (teamResult != null) {
                setLeagues(teamResult.api.teams)
            } else {
                setLeagues(emptyList<Team>())
            }
        }

        override fun onFailure(
            call: Call<ApiTeam?>,
            t: Throwable
        ) {
            setLeagues(emptyList<Team>())
        }
    }

}