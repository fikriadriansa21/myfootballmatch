package com.example.myfootballmatch.ui.team.register

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.league.ApiLeague
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.model.team.ApiTeam
import com.example.myfootballmatch.data.network.model.team.Team
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.data.network.services.TeamService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class TeamRegisterViewModel(private var teamService: TeamService) : BaseViewModel(){

    var team: MutableLiveData<List<Team>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadLeaguesNetwork() {
        setIsLoading(true)
        teamService.getTeamFromLeagueId(524)
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

    private fun setLeagues(teams: List<Team>) {
        setIsLoading(false)
        team.value=teams
    }

    private var callback = object : Callback<ApiTeam> {
        override fun onResponse(@NonNull call: Call<ApiTeam?>, @NonNull response: Response<ApiTeam?>) {
            val teamResult: ApiTeam? = response.body()
            if (teamResult != null) {
                Log.d("asdakasas","result tidak null")

                setLeagues(teamResult.api.teams)
                Log.d("asdakasas",teamResult.api.teams[0].name)
            } else {
                Log.d("asdakasas","result null")

                setLeagues(emptyList<Team>())
            }
        }

        override fun onFailure(
            call: Call<ApiTeam?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setLeagues(emptyList<Team>())
        }
    }

}