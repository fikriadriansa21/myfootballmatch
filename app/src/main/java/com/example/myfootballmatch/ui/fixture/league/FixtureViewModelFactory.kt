package com.example.myfootballmatch.ui.fixture.league

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfootballmatch.data.network.services.FixtureLeagueService
import java.lang.IllegalArgumentException

class FixtureViewModelFactory(private var fixtureLeagueService: FixtureLeagueService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FixtureViewModel::class.java)){
            return FixtureViewModel(fixtureLeagueService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}