package com.krayz.myfootballmatch.ui.squad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.services.PlayerService
import com.krayz.myfootballmatch.ui.team.TeamFragment
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_squad.*

class SquadActivity : AppCompatActivity(), SquadAdapter.SquadListener {
    companion object { const val TEAM_SQUAD = "TEAM_SQUAD" }
    private lateinit var playerService: PlayerService
    lateinit var squadAdapter: SquadAdapter
    private lateinit var viewModelSquad : SquadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad)

        Utils.makeSharedPreference(this)

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

        viewModelSquad.loadPlayerNetwork(Utils.getIntSharedPrefereces(Utils.TEAM_ID),"2019-2020")
        btn_back_myteam.setOnClickListener {
            val intent = Intent(this, TeamFragment::class.java)
            startActivity(intent)
        }
    }

    private fun createViewModel(): SquadViewModel {
        val factory = SquadViewModelFactory(playerService)
        return ViewModelProviders.of(this, factory)[SquadViewModel::class.java]
    }

    override fun onSquadListener(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
