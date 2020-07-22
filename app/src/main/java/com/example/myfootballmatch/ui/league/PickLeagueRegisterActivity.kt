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
import com.example.myfootballmatch.data.network.model.League
import com.example.myfootballmatch.data.network.services.LeagueService
import com.example.myfootballmatch.ui.base.BaseActivity


class PickLeagueRegisterActivity : BaseActivity<LeagueViewModel>(), LeagueAdapter.LeagueListener{

    @BindView(R.id.rv_league)
    lateinit var rvLeague: RecyclerView

    @BindView(R.id.progress_bar_league)
    lateinit var pbLeague: ProgressBar

    private val leagueService: LeagueService? = null
    lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)

        ButterKnife.bind(this)
        leagueAdapter = LeagueAdapter(this)
        rvLeague.adapter = leagueAdapter

        viewModel?.getLoadingStatus()?.observe(this, loadingObserver)
        viewModel?.getLeagues()
    }

    override fun createViewModel(): LeagueViewModel {
        val factory = leagueService?.let { LeagueViewModelFactory(it) }
        return ViewModelProviders.of(this, factory)[LeagueViewModel::class.java]
    }


    private var loadingObserver = object : Observer<Boolean?> {
        override fun onChanged(@Nullable isLoading: Boolean?) {
            if (isLoading == null) return
            if (isLoading) {
                pbLeague.setVisibility(View.VISIBLE)
            } else {
                pbLeague.setVisibility(View.GONE)
            }
        }
    }





    override fun onLeagueListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
