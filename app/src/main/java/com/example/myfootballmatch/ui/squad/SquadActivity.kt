package com.example.myfootballmatch.ui.squad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.services.PlayerService
import com.example.myfootballmatch.data.network.services.TeamService
import com.example.myfootballmatch.ui.team.register.TeamAdapter
import com.example.myfootballmatch.ui.team.register.TeamRegisterActivity
import com.example.myfootballmatch.ui.team.register.TeamRegisterViewModel
import com.example.myfootballmatch.ui.team.register.TeamRegisterViewModelFactory
import kotlinx.android.synthetic.main.activity_pick_team_register.*
import kotlinx.android.synthetic.main.activity_squad.*

class SquadActivity : AppCompatActivity(), SquadAdapter.SquadListener {
    companion object { const val TEAM_SQUAD = "TEAM_SQUAD" }
    private lateinit var playerService: PlayerService
    lateinit var squadAdapter: SquadAdapter
    private lateinit var viewModelSquad : SquadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad)

        squadAdapter = SquadAdapter(this)
        rv_squad_member.layoutManager = LinearLayoutManager(this)
        rv_squad_member.setHasFixedSize(true)
        rv_squad_member.adapter = squadAdapter
        playerService = NetworkConfig.playerService
        viewModelSquad = createViewModel()

        viewModelSquad.player.observe(this, Observer{
            squadAdapter.setItems(it)
            squadAdapter.notifyDataSetChanged()
        })

        viewModelSquad.loadPlayerNetwork(intent.getIntExtra(TEAM_SQUAD,0),"2019-2020")
    }

    private fun createViewModel(): SquadViewModel {
        val factory = SquadViewModelFactory(playerService)
        return ViewModelProviders.of(this, factory)[SquadViewModel::class.java]
    }

    override fun onSquadListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
