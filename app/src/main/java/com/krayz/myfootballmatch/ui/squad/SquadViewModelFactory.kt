package com.krayz.myfootballmatch.ui.squad

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.PlayerService
import com.krayz.myfootballmatch.ui.league.LeagueViewModel
import java.lang.IllegalArgumentException

class SquadViewModelFactory(private var playerService: PlayerService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SquadViewModel::class.java)){
            return SquadViewModel(playerService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}