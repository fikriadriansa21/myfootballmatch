package com.krayz.myfootballmatch.ui.statistic

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayz.myfootballmatch.data.network.services.StatisticService
import java.lang.IllegalArgumentException

class StatisticViewModelFactory(private var statisticService: StatisticService): ViewModelProvider.Factory{
    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatisticViewModel::class.java)){
            return StatisticViewModel(statisticService) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}