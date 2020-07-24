package com.example.myfootballmatch.ui.team.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.services.TeamService
import com.example.myfootballmatch.ui.league.PickLeagueRegisterActivity
import com.example.myfootballmatch.ui.main.MainActivity
import com.example.myfootballmatch.ui.success.SuccessRegistrationActivity
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_pick_team_register.*
import kotlinx.android.synthetic.main.activity_register.*

class TeamRegisterActivity : AppCompatActivity(), TeamAdapter.TeamListener {
    companion object { const val EXTRA_LEAGUE_ID = "EXTRA_LEAGUE_ID" }
    private lateinit var teamService: TeamService
    lateinit var teamAdapter: TeamAdapter
    private lateinit var viewModel : TeamRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_team_register)

        btn_back_league.setOnClickListener {
            val intent = Intent(this, PickLeagueRegisterActivity::class.java)
            startActivity(intent)
        }

        teamAdapter =
            TeamAdapter(this)

        rv_team.layoutManager = LinearLayoutManager(this)
        rv_team.setHasFixedSize(true)
        rv_team.adapter = teamAdapter
        teamService = NetworkConfig.teamService
        viewModel = createViewModel()

        viewModel.team.observe(this, Observer{
            teamAdapter.setItems(it)
            teamAdapter.notifyDataSetChanged()
        })
        viewModel.loadTeamNetwork(intent.getIntExtra(EXTRA_LEAGUE_ID,0))
    }

    private fun createViewModel(): TeamRegisterViewModel {
        val factory = TeamRegisterViewModelFactory(teamService)
        return ViewModelProviders.of(this, factory)[TeamRegisterViewModel::class.java]
    }

    override fun onTeamListener(id: Int, name: String) {
        val intent = Intent(this, SuccessRegistrationActivity::class.java)
        Utils.makeSharedPreference(this)
        Utils.putSharedPreferences(Utils.TEAM_ID, id)
        Utils.putSharedPreferences(Utils.TEAM_NAME, name)
        startActivity(intent)
    }
}
