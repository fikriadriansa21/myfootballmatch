package com.krayz.myfootballmatch.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.NetworkConfig
import com.krayz.myfootballmatch.data.network.services.SearchTeamService
import com.krayz.myfootballmatch.data.network.services.TeamService
import com.krayz.myfootballmatch.ui.team.register.TeamAdapter
import com.krayz.myfootballmatch.ui.team.register.TeamRegisterActivity
import com.krayz.myfootballmatch.ui.team.register.TeamRegisterViewModel
import com.krayz.myfootballmatch.ui.team.register.TeamRegisterViewModelFactory
import kotlinx.android.synthetic.main.activity_pick_team_register.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), TeamAdapter.TeamListener {
    private lateinit var searchTeamService: SearchTeamService
    lateinit var teamAdapter: TeamAdapter
    private lateinit var viewModel : SearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamAdapter = TeamAdapter(this)

        rv_search_team.layoutManager = LinearLayoutManager(this.context)
        rv_search_team.setHasFixedSize(true)
        rv_search_team.adapter = teamAdapter
        searchTeamService = NetworkConfig.searchTeamService
        viewModel = createViewModel()

        viewModel.team.observe(this, Observer{
            if (it != null ){
                teamAdapter.setItems(it)
            }
            teamAdapter.notifyDataSetChanged()
        })
        et_search_team.addTextChangedListener ( object: TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.loadSearchTeam(s.toString())

            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun createViewModel(): SearchViewModel {
        val factory = SearchViewModelFactory(searchTeamService)
        return ViewModelProviders.of(this, factory)[SearchViewModel::class.java]
    }

    override fun onTeamListener(id: Int, name: String, logo: String, stadium: String) {

    }

}
