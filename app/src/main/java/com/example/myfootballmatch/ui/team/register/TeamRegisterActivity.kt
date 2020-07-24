package com.example.myfootballmatch.ui.team.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.model.team.Team
import com.example.myfootballmatch.data.network.services.TeamService
import com.example.myfootballmatch.ui.team.adapter.TeamAdapter
import kotlinx.android.synthetic.main.activity_pick_league_register.*

class TeamRegisterActivity : AppCompatActivity(), TeamAdapter.TeamListener {

    private val EXTRA_MOVIE = "EXTRA_MOVIE"
    private lateinit var teamService: TeamService
    lateinit var teamAdapter: TeamAdapter
    private lateinit var viewModel : TeamRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)

        teamAdapter = TeamAdapter(this)

        rv_league.layoutManager = LinearLayoutManager(this)
        rv_league.setHasFixedSize(true)
        rv_league.adapter = teamAdapter
        teamService = NetworkConfig.teamService
        viewModel = createViewModel()

        viewModel.team.observe(this, Observer{
            Log.d("cjxchsasasa",it[0].name)
            Log.d("cjxchsasasa","league henshin")

            teamAdapter.setItems(it)
            teamAdapter.notifyDataSetChanged()
        })
        viewModel.loadLeaguesNetwork()
    }

    private fun createViewModel(): TeamRegisterViewModel {
        val team: Team = intent.getParcelableExtra(EXTRA_MOVIE)
        val factory = TeamRegisterViewModelFactory(teamService)
        return ViewModelProviders.of(this, factory)[TeamRegisterViewModel::class.java]
    }

    fun start(context: Context, id: Int) {
        val starter = Intent(context, TeamRegisterActivity::class.java)
        starter.putExtra(EXTRA_MOVIE, id)
        context.startActivity(starter)
    }

    override fun onTeamListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
