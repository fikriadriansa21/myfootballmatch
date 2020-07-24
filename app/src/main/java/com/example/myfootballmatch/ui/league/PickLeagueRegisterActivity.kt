package com.example.myfootballmatch.ui.league

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.model.team.Team
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.ui.team.register.TeamRegisterActivity
import kotlinx.android.synthetic.main.activity_pick_league_register.*


class PickLeagueRegisterActivity : AppCompatActivity(), LeagueAdapter.LeagueListener{

    private lateinit var leagueService: LeagueService
    lateinit var leagueAdapter: LeagueAdapter
    private lateinit var viewModel : LeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)

        ButterKnife.bind(this)
        leagueAdapter = LeagueAdapter(this)
        rv_league.layoutManager = LinearLayoutManager(this)
        rv_league.setHasFixedSize(true)
        rv_league.adapter = leagueAdapter
        leagueService = NetworkConfig.leagueService
        viewModel = createViewModel()

        viewModel.league.observe(this, Observer{
            Log.d("cjxchsasasa",it[0].name)
            Log.d("cjxchsasasa","league henshin")

            leagueAdapter.setItems(it)
            leagueAdapter.notifyDataSetChanged()
        })
        viewModel.loadLeaguesNetwork()
    }

    private fun createViewModel(): LeagueViewModel {
        val factory = LeagueViewModelFactory(leagueService)
        return ViewModelProviders.of(this, factory)[LeagueViewModel::class.java]
    }

    private var loadingObserver = object : Observer<Boolean?> {
        override fun onChanged(@Nullable isLoading: Boolean?) {
            if (isLoading == null) return
            if (isLoading) {
                progress_bar_league.setVisibility(View.VISIBLE)
            } else {
                progress_bar_league.setVisibility(View.GONE)
            }
        }
    }

    private var movieObserver = object : Observer<List<League?>?> {
        override fun onChanged(@Nullable league: List<League?>?) {
            if (league == null) return
            leagueAdapter.setItems(league)
//            if (league.isEmpty()) {
//                emptyView.setVisibility(View.VISIBLE)
//            } else {
//                emptyView.setVisibility(View.GONE)
//            }
        }
    }
    override fun onLeagueListener(id: Int) {
        val teamActivity = TeamRegisterActivity()
        val league = League()
        league.league_id?.let { teamActivity.start(this, it) }
    }
}
