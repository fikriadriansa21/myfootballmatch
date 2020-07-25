package com.example.myfootballmatch.ui.team.lastmatch

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import com.example.myfootballmatch.data.network.model.fixture.Fixture
import com.example.myfootballmatch.data.network.services.FixtureTeamService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LastMatchViewModel(private var fixtureTeamService: FixtureTeamService) : BaseViewModel(){

    var fixture: MutableLiveData<List<Fixture>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadFixtureTeamNetwork(id: Int) {
        setIsLoading(true)
        fixtureTeamService.getFixtureTeam(id).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setFixturesLatMatch(fixtures: List<Fixture>) {
        setIsLoading(false)
        fixture.value=fixtures
    }

    private var callback = object : Callback<ApiFixture> {
        override fun onResponse(@NonNull call: Call<ApiFixture?>, @NonNull response: Response<ApiFixture?>) {
            val lastMatchResult: ApiFixture? = response.body()
            if (lastMatchResult != null) {
                setFixturesLatMatch(lastMatchResult.api.fixtures)
            } else {
                setFixturesLatMatch(emptyList<Fixture>())
            }
        }

        override fun onFailure(
            call: Call<ApiFixture?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")
            setFixturesLatMatch(emptyList<Fixture>())
        }
    }

}