package com.krayz.myfootballmatch.ui.league

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.LeagueService
import java.lang.IllegalArgumentException

class LeagueViewModelFactory(private var leagueService: LeagueService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueViewModel::class.java)){
            return LeagueViewModel(leagueService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}

