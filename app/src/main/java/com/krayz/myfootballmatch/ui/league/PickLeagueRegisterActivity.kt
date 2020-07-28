package com.krayz.myfootballmatch.ui.league

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.model.league.League
import com.krayz.myfootballmatch.data.network.services.LeagueService
import com.krayz.myfootballmatch.ui.register.RegisterActivity
import com.krayz.myfootballmatch.ui.team.register.TeamRegisterActivity
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_pick_league_register.*


class PickLeagueRegisterActivity : AppCompatActivity(), LeagueAdapter.LeagueListener{

    private lateinit var leagueService: LeagueService
    lateinit var leagueAdapter: LeagueAdapter
    private lateinit var viewModel : LeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)

        btn_back_account.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        leagueAdapter = LeagueAdapter(this)
        rv_league.layoutManager = LinearLayoutManager(this)
        rv_league.setHasFixedSize(true)
        rv_league.adapter = leagueAdapter
        leagueService = NetworkConfig.leagueService
        viewModel = createViewModel()

        viewModel.league.observe(this, Observer{
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
                progress_bar_league.visibility = View.VISIBLE
            } else {
                progress_bar_league.visibility = View.GONE
            }
        }
    }

    private var leagueObserver = object : Observer<List<League?>?> {
        override fun onChanged(@Nullable league: List<League?>?) {
            if (league == null) return
            leagueAdapter.setItems(league)
        }
    }
    override fun onLeagueListener(id: Int, name: String) {
        val intent = Intent(this, TeamRegisterActivity::class.java)
        intent.putExtra(TeamRegisterActivity.EXTRA_LEAGUE_ID,id)
        Utils.makeSharedPreference(this)
        Utils.putSharedPreferences(Utils.LEAGUE_ID, id)
        Utils.putSharedPreferences(Utils.LEAGUE_NAME, name)
        startActivity(intent)
    }
}
