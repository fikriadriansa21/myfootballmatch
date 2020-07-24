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
import com.example.myfootballmatch.data.network.services.StandingService
import com.example.myfootballmatch.ui.league.LeagueAdapter
import com.example.myfootballmatch.ui.league.LeagueViewModel
import com.example.myfootballmatch.ui.league.LeagueViewModelFactory
import com.example.myfootballmatch.ui.standing.StandingAdapter
import com.example.myfootballmatch.ui.standing.StandingViewModel
import com.example.myfootballmatch.ui.standing.StandingViewModelFactory
import kotlinx.android.synthetic.main.activity_pick_league_register.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), StandingAdapter.StandingListener {

    private lateinit var standingService: StandingService
    lateinit var standingAdapter: StandingAdapter
    private lateinit var viewModel : StandingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStandingListener(id: Int) {
        standingAdapter = StandingAdapter(this)
        rv_league_table.layoutManager = LinearLayoutManager(this.context)
        rv_league_table.setHasFixedSize(true)
        rv_league_table.adapter = standingAdapter
        standingService = NetworkConfig.standingService
        viewModel = createViewModel()

        viewModel.standings.observe(this, Observer{
            Log.d("cjxchsasasa",it[0].teamName)
            Log.d("cjxchsasasa","league henshin")

            standingAdapter.setItems(it)
            standingAdapter.notifyDataSetChanged()
        })
        viewModel.loadStandingNetwork()
    }

    private fun createViewModel(): StandingViewModel {
        val factory = StandingViewModelFactory(standingService)
        return ViewModelProviders.of(this, factory)[StandingViewModel::class.java]
    }

}
