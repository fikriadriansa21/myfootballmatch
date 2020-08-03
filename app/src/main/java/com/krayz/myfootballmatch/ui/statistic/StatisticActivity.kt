package com.krayz.myfootballmatch.ui.statistic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.services.StatisticService
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_statistic.*

class StatisticActivity : AppCompatActivity() {

    private lateinit var viewModel: StatisticViewModel
    private lateinit var statisticService: StatisticService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic)

        Utils.makeSharedPreference(this)

        statisticService = NetworkConfig.statisticService
        viewModel = createViewModel()

        viewModel.statistics.observe(this, Observer {
            tv_win_total.text = it!!.matchs.wins.total.toString()
            tv_draw_total.text = it.matchs.draws.total.toString()
            tv_lose_total.text = it.matchs.loses.total.toString()
            tv_home_match.text = it.matchs.matchsPlayed.home.toString()
            tv_away_match.text = it.matchs.matchsPlayed.away.toString()
            tv_goal_for_score.text = it.goals.goalForGoals.total.toString()
            tv_goal_against_score.text = it.goals.goalAgainstGoals.total.toString()
            tv_goal_for_score_average.text = it.goalsAvg.goalForAverage.total.toString()
            tv_goal_against_score_average.text = it.goalsAvg.goalAgainstAverage.total.toString()
        })

        viewModel.loadStatisticNetwork(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID), Utils.getIntSharedPrefereces(Utils.TEAM_ID))

        btn_back_myteam.setOnClickListener {
            finish()
        }

    }

    private fun createViewModel(): StatisticViewModel {
        val factory = StatisticViewModelFactory(statisticService)
        return ViewModelProviders.of(this, factory)[StatisticViewModel::class.java]
    }
}
