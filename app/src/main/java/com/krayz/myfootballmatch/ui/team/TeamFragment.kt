package com.krayz.myfootballmatch.ui.team

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.model.fixture.Fixture
import com.krayz.myfootballmatch.data.network.services.FixtureTeamService
import com.krayz.myfootballmatch.data.network.services.TeamService
import com.krayz.myfootballmatch.ui.squad.SquadActivity
import com.krayz.myfootballmatch.ui.statistic.StatisticActivity
import com.krayz.myfootballmatch.ui.team.lastmatch.LastMatchAdapter
import com.krayz.myfootballmatch.ui.team.lastmatch.LastMatchViewModel
import com.krayz.myfootballmatch.ui.team.lastmatch.LastMatchViewModelFactory
import com.krayz.myfootballmatch.ui.team.register.TeamAdapter
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_pick_league_register.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_team.*


class TeamFragment : Fragment(), LastMatchAdapter.LastMatchListener{

    private lateinit var fixtureTeamService: FixtureTeamService
    lateinit var lastMatchAdapter: LastMatchAdapter
    private lateinit var viewModelLastMatchTeam : LastMatchViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val snapHelper: SnapHelper = LinearSnapHelper()
        Utils.makeSharedPreference(this.context as Activity)

        lastMatchAdapter = LastMatchAdapter(this)
        rv_upcoming_match.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rv_upcoming_match.setHasFixedSize(true)
        snapHelper.attachToRecyclerView(rv_upcoming_match)

        rv_upcoming_match.adapter = lastMatchAdapter
        fixtureTeamService = NetworkConfig.fixtureTeamService
        viewModelLastMatchTeam = createLastMatchViewModel()

        viewModelLastMatchTeam.fixture.observe(this, Observer{
            lastMatchAdapter.setItems(it)
            lastMatchAdapter.notifyDataSetChanged()
        })
        viewModelLastMatchTeam.loadFixtureTeamNetwork(Utils.getIntSharedPrefereces(Utils.TEAM_ID))
        tv_club_favorite_title.text = Utils.getSharedPrefereces(Utils.TEAM_NAME)

        card_squad_member.setOnClickListener {
            val intent = Intent(this.context, SquadActivity::class.java)
            startActivity(intent)
        }

        card_statistic_club.setOnClickListener {
            val intent = Intent(this.context, StatisticActivity::class.java)
            startActivity(intent)
        }

        val teamName = Utils.getSharedPrefereces(Utils.TEAM_NAME)
        tv_club.text = teamName

        val teamStadium = Utils.getSharedPrefereces(Utils.STADIUM_NAME)
        tv_stadium.text = teamStadium

        val imageClub = Utils.getSharedPrefereces(Utils.LOGO_TEAM)
        context?.let {
            Glide.with(it)
                .load(imageClub)
                .override(124,124)
                .into(iv_club_logo)
        }

    }

    private fun createLastMatchViewModel(): LastMatchViewModel {
        val lastMatchFactory = LastMatchViewModelFactory(fixtureTeamService)
        return ViewModelProviders.of(this, lastMatchFactory)[LastMatchViewModel::class.java]
    }

    private var loadingObserver = object : Observer<Boolean?> {
        override fun onChanged(@Nullable isLoading: Boolean?) {
            if (isLoading == null) return
            if (isLoading) {
                progress_bar_league.visibility = View.VISIBLE
            } else {
                progress_bar_league.visibility = View.GONE
            }
        }
    }

    private var fixtureTeamObserver = object : Observer<List<Fixture?>?> {
        override fun onChanged(@Nullable fixtureTeam: List<Fixture?>?) {
            if (fixtureTeam == null) return
            lastMatchAdapter.setItems(fixtureTeam)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onLastMatchListener(id: Int) {

    }

}
