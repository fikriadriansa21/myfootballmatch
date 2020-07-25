package com.example.myfootballmatch.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.services.FixtureLeagueService
import com.example.myfootballmatch.data.network.services.StandingService
import com.example.myfootballmatch.data.network.services.TopScoreService
import com.example.myfootballmatch.ui.fixture.league.FixtureAdapter
import com.example.myfootballmatch.ui.fixture.league.FixtureViewModel
import com.example.myfootballmatch.ui.fixture.league.FixtureViewModelFactory
import com.example.myfootballmatch.ui.standing.StandingAdapter
import com.example.myfootballmatch.ui.standing.StandingViewModel
import com.example.myfootballmatch.ui.standing.StandingViewModelFactory
import com.example.myfootballmatch.ui.topscorer.TopScorerAdapter
import com.example.myfootballmatch.ui.topscorer.TopScorerViewModel
import com.example.myfootballmatch.ui.topscorer.TopScorerViewModelFactory
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), StandingAdapter.StandingListener , FixtureAdapter.FixtureListener, TopScorerAdapter.TopScorerListener{

    private lateinit var standingService: StandingService
    private lateinit var fixtureLeagueService: FixtureLeagueService
    private lateinit var topScorerService: TopScoreService
    lateinit var standingAdapter: StandingAdapter
    lateinit var fixtureAdapter: FixtureAdapter
    lateinit var topScorerAdapter: TopScorerAdapter
    private lateinit var standingViewModel : StandingViewModel
    private lateinit var fixtureViewModel: FixtureViewModel
    private lateinit var topScorerViewModel: TopScorerViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.activity?.let { Utils.makeSharedPreference(it) }

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

        fixtureLeagueService = NetworkConfig.fixtureLeagueService
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
        fixtureViewModel.loadFixtureLeague(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID))
        topScorerViewModel.loadTopScorerNetwork(Utils.getIntSharedPrefereces(Utils.LEAGUE_ID))
//        tv_league_name_title.text = Utils.getSharedPrefereces(Utils.LEAGUE_NAME)
//        tv_league_name_1.text = Utils.getSharedPrefereces(Utils.LEAGUE_NAME)
//        tv_league_name_2.text = Utils.getSharedPrefereces(Utils.LEAGUE_NAME)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun createViewModelStanding(): StandingViewModel {
        val standingFactory = StandingViewModelFactory(standingService)
        return ViewModelProviders.of(this, standingFactory)[StandingViewModel::class.java]
    }

    private fun createViewModelFixture(): FixtureViewModel {
        val fixtureFactory = FixtureViewModelFactory(fixtureLeagueService)
        return ViewModelProviders.of(this, fixtureFactory)[FixtureViewModel::class.java]
    }

    private fun createViewModelTopScorer(): TopScorerViewModel {
        val topScorerFactory = TopScorerViewModelFactory(topScorerService)

        return ViewModelProviders.of(this, topScorerFactory)[TopScorerViewModel::class.java]

    }

    override fun onStandingListener(id: Int) {

    }

    override fun onFixtureListener(id: Int) {

    }

    override fun onTopScorerListener(id: Int) {

    }

}
