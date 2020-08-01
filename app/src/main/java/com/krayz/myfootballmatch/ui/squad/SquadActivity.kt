package com.krayz.myfootballmatch.ui.squad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.services.PlayerService
import com.krayz.myfootballmatch.ui.team.TeamFragment
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_squad.*



class  SquadActivity : AppCompatActivity(){
    private lateinit var playerService: PlayerService
    lateinit var squadAdapter: SquadAdapter
    private lateinit var viewModelSquad : SquadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad)

        Utils.makeSharedPreference(this)

        squadAdapter = SquadAdapter()
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
            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as TeamFragment
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    private fun createViewModel(): SquadViewModel {
        val factory = SquadViewModelFactory(playerService)
        return ViewModelProviders.of(this, factory)[SquadViewModel::class.java]
    }
}
