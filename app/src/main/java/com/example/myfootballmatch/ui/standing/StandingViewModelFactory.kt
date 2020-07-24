package com.example.myfootballmatch.ui.standing

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfootballmatch.data.network.services.StandingService
import com.example.myfootballmatch.ui.league.LeagueViewModel
import java.lang.IllegalArgumentException

class StandingViewModelFactory(private var standingService: StandingService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueViewModel::class.java)){
            return StandingViewModel(standingService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}