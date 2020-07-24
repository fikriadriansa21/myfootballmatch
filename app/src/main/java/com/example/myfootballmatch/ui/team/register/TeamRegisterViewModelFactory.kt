package com.example.myfootballmatch.ui.team.register

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.services.TeamService
import java.lang.IllegalArgumentException

class TeamRegisterViewModelFactory(private var teamService: TeamService, private var league: League): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamRegisterViewModel::class.java)){
            return TeamRegisterViewModel(teamService,league) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}