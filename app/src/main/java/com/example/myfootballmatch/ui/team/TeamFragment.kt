package com.example.myfootballmatch.ui.team

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.NetworkConfig
import com.example.myfootballmatch.data.network.model.fixture.Fixture
import com.example.myfootballmatch.data.network.services.FixtureTeamService
import com.example.myfootballmatch.ui.squad.SquadActivity
import com.example.myfootballmatch.ui.squad.SquadAdapter
import com.example.myfootballmatch.ui.team.lastmatch.LastMatchAdapter
import com.example.myfootballmatch.ui.team.lastmatch.LastMatchViewModel
import com.example.myfootballmatch.ui.team.lastmatch.LastMatchViewModelFactory
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_pick_league_register.*
import kotlinx.android.synthetic.main.fragment_team.*


class TeamFragment : Fragment(), LastMatchAdapter.LastMatchListener{

    private lateinit var fixtureTeamService: FixtureTeamService
    lateinit var lastMatchAdapter: LastMatchAdapter
    private lateinit var viewModelLastMatchTeam : LastMatchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lastMatchAdapter = LastMatchAdapter(this)
        rv_upcoming_match.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        rv_upcoming_match.setHasFixedSize(true)
        rv_upcoming_match.adapter = lastMatchAdapter
        fixtureTeamService = NetworkConfig.fixtureTeamService
        viewModelLastMatchTeam = createLastMatchViewModel()

        viewModelLastMatchTeam.fixture.observe(this, Observer{
            lastMatchAdapter.setItems(it)
            lastMatchAdapter.notifyDataSetChanged()
        })
        viewModelLastMatchTeam.loadFixtureTeamNetwork(Utils.getIntSharedPrefereces(Utils.TEAM_ID))
        tv_club_favorite_title.text = Utils.getSharedPrefereces(Utils.TEAM_NAME)

//        card_squad_member.setOnClickListener {
//            squadIntent(Utils.getIntSharedPrefereces(Utils.TEAM_ID))
//        }

//        card_squad_member.setOnClickListener {
//            val intent = Intent(activity, SquadActivity::class.java)
//            Utils.makeSharedPreference(activity!!)
//            intent.putExtra(SquadActivity.TEAM_SQUAD,Utils.getIntSharedPrefereces(Utils.TEAM_ID))
//
//            startActivity(intent)
//        }

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

    private fun squadIntent(id: Int){
        val intent = Intent(activity, SquadActivity::class.java)
        Utils.makeSharedPreference(activity!!)
        intent.putExtra(SquadActivity.TEAM_SQUAD,id)

        startActivity(intent)
    }
}
