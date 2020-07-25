package com.example.myfootballmatch.ui.topscorer

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfootballmatch.data.network.services.TopScoreService
import com.example.myfootballmatch.ui.league.LeagueViewModel
import java.lang.IllegalArgumentException

class TopScorerViewModelFactory(private var topScoreService: TopScoreService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopScorerViewModel::class.java)){
            return TopScorerViewModel(topScoreService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}