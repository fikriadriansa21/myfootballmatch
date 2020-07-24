package com.example.myfootballmatch.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.services.FixtureService
import com.example.myfootballmatch.data.network.services.PlayerService
import com.example.myfootballmatch.data.network.services.StandingService
import com.example.myfootballmatch.data.network.services.TopScoreService
import com.example.myfootballmatch.ui.fixture.FixtureAdapter
import com.example.myfootballmatch.ui.fixture.FixtureViewModel
import com.example.myfootballmatch.ui.fixture.FixtureViewModelFactory
import com.example.myfootballmatch.ui.league.LeagueAdapter
import com.example.myfootballmatch.ui.league.LeagueViewModel
import com.example.myfootballmatch.ui.league.LeagueViewModelFactory
import com.example.myfootballmatch.ui.squad.SquadAdapter
import com.example.myfootballmatch.ui.standing.StandingAdapter
import com.example.myfootballmatch.ui.standing.StandingViewModel
import com.example.myfootballmatch.ui.standing.StandingViewModelFactory
import com.example.myfootballmatch.ui.topscorer.TopScorerAdapter
import com.example.myfootballmatch.ui.topscorer.TopScorerViewModel
import com.example.myfootballmatch.ui.topscorer.TopScorerViewModelFactory
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_pick_league_register.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), StandingAdapter.StandingListener , FixtureAdapter.FixtureListener, TopScorerAdapter.TopScorerListener{

    private lateinit var standingService: StandingService
    private lateinit var fixtureService: FixtureService
    private lateinit var topScorerService: TopScoreService
    lateinit var standingAdapter: StandingAdapter
    lateinit var fixtureAdapter: FixtureAdapter
    lateinit var topScorerAdapter: TopScorerAdapter
    private lateinit var standingViewModel : StandingViewModel
    private lateinit var fixtureViewModel: FixtureViewModel
    private lateinit var topScorerViewModel: TopScorerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        standingAdapter = StandingAdapter(this)
        fixtureAdapter = FixtureAdapter(this)
        topScorerAdapter = TopScorerAdapter(this)

        rv_league_table.layoutManager = LinearLayoutManager(this.context)
        rv_league_table.setHasFixedSize(true)
        rv_league_table.adapter = standingAdapter

        rv_matchweek.layoutManager = LinearLayoutManager(this.context)
        rv_matchweek.setHasFixedSize(true)
        rv_matchweek.adapter = fixtureAdapter

        rv_topscorer.layoutManager = LinearLayoutManager(this.context)
        rv_topscorer.setHasFixedSize(true)
        rv_topscorer.adapter = topScorerAdapter

        standingService = NetworkConfig.standingService
        standingViewModel = createViewModelStanding()

        fixtureService = NetworkConfig.fixtureService
        fixtureViewModel = createViewModelFixture()

        topScorerService = NetworkConfig.topScoreService
        topScorerViewModel = createViewModelTopScorer()

        standingViewModel.standings.observe(this, Observer{
            standingAdapter.setItems(it)
            standingAdapter.notifyDataSetChanged()
        })

        fixtureViewModel.fixture.observe(this, Observer{
            fixtureAdapter.setItems(it)
            fixtureAdapter.notifyDataSetChanged()
        })

        topScorerViewModel.topScorers.observe(this, Observer{
            topScorerAdapter.setItems(it)
            topScorerAdapter.notifyDataSetChanged()
        })

        standingViewModel.loadStandingNetwork(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID))
        fixtureViewModel.loadFixtureByLeagueId(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID))
        topScorerViewModel.loadTopScorerNetwork(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStandingListener(id: Int) {

    }

    private fun createViewModelStanding(): StandingViewModel {
        val standingStanding = StandingViewModelFactory(standingService)
        return ViewModelProviders.of(this, standingStanding)[StandingViewModel::class.java]
    }

    private fun createViewModelFixture(): FixtureViewModel {
        val fixtureStanding = FixtureViewModelFactory(fixtureService)
        return ViewModelProviders.of(this, fixtureStanding)[FixtureViewModel::class.java]
    }

    private fun createViewModelTopScorer(): TopScorerViewModel {
        val topScorerStanding = TopScorerViewModelFactory(topScorerService)

        return ViewModelProviders.of(this, topScorerStanding)[TopScorerViewModel::class.java]

    }

    override fun onFixtureListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTopScorerListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
