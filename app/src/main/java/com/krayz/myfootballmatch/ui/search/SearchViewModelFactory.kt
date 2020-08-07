package com.krayz.myfootballmatch.ui.search

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.SearchTeamService
import java.lang.IllegalArgumentException

class SearchViewModelFactory(private var searchTeamService: SearchTeamService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)){
            return SearchViewModel(searchTeamService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}