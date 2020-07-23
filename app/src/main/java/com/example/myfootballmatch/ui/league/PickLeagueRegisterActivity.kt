package com.example.myfootballmatch.ui.league

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig.leagueService
import com.example.myfootballmatch.data.network.model.league.League
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.ui.base.BaseActivity


class PickLeagueRegisterActivity : BaseActivity<LeagueViewModel>(), LeagueAdapter.LeagueListener{

    @BindView(R.id.rv_league)
    private var rvLeague: RecyclerView? = null

    @BindView(R.id.progress_bar_league)
     val pbLeague: ProgressBar? = null
    private var leagueAdapter: LeagueAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)

        ButterKnife.bind(this)
        leagueAdapter = LeagueAdapter(this)
        rvLeague?.adapter = leagueAdapter

        viewModel?.getLoadingStatus()?.observe(this, loadingObserver)
        viewModel?.getLeagues(this, movieObserver)
        viewModel?.loadLeaguesNetwork()
    }

    override fun createViewModel(): LeagueViewModel {
        val factory = leagueService?.let { LeagueViewModelFactory(it) }
        return ViewModelProviders.of(this, factory)[LeagueViewModel::class.java]
    }

    private var loadingObserver = object : Observer<Boolean?> {
        override fun onChanged(@Nullable isLoading: Boolean?) {
            if (isLoading == null) return
            if (isLoading) {
                pbLeague?.visibility = View.VISIBLE
            } else {
                pbLeague?.visibility = View.GONE
            }
        }
    }

    private var movieObserver = object : Observer<List<League?>?> {
        override fun onChanged(@Nullable league: List<League?>?) {
            if (league == null) return
            leagueAdapter?.setItems(league)
        }
    }
    override fun onLeagueListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
