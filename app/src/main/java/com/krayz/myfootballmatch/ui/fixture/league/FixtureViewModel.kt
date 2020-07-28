package com.krayz.myfootballmatch.ui.fixture.league

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.fixture.ApiFixture
import com.krayz.myfootballmatch.data.network.model.fixture.Fixture
import com.krayz.myfootballmatch.data.network.services.FixtureLeagueService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FixtureViewModel(private var fixtureLeagueService: FixtureLeagueService) : BaseViewModel(){

    var fixture: MutableLiveData<List<Fixture>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }

    fun loadFixtureLeague(id: Int) {
        setIsLoading(true)
        fixtureLeagueService.getFixtureLeague(id).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setFixtureLeague(fixtures: List<Fixture>) {
        setIsLoading(false)
        fixture.value = fixtures
    }

    private var callback = object : Callback<ApiFixture> {
        override fun onResponse(@NonNull call: Call<ApiFixture?>, @NonNull response: Response<ApiFixture?>) {
            val fixtureByLeagueIdResult: ApiFixture? = response.body()
            if (fixtureByLeagueIdResult != null) {
                Log.d("asdakasas","result tidak null")
                setFixtureLeague(fixtureByLeagueIdResult.api.fixtures)
            } else {
                Log.d("asdakasas","result null")
                setFixtureLeague(emptyList<Fixture>())
            }
        }

        override fun onFailure(
            call: Call<ApiFixture?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")
            setFixtureLeague(emptyList<Fixture>())
        }
    }

}