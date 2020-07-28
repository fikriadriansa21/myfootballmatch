package com.krayz.myfootballmatch.ui.team.lastmatch

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.FixtureTeamService
import java.lang.IllegalArgumentException

class LastMatchViewModelFactory(private var fixtureTeamService: FixtureTeamService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LastMatchViewModel::class.java)){
            return LastMatchViewModel(fixtureTeamService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}