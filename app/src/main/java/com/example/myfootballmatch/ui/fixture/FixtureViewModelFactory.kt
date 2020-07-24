package com.example.myfootballmatch.ui.fixture

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfootballmatch.data.network.services.FixtureService
import com.example.myfootballmatch.ui.league.LeagueViewModel
import java.lang.IllegalArgumentException

class FixtureViewModelFactory(private var fixtureService: FixtureService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueViewModel::class.java)){
            return FixtureViewModel(fixtureService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}