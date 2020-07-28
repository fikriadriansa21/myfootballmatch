package com.krayz.myfootballmatch.ui.team.register

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.TeamService
import java.lang.IllegalArgumentException

class TeamRegisterViewModelFactory(private var teamService: TeamService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamRegisterViewModel::class.java)){
            return TeamRegisterViewModel(teamService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}