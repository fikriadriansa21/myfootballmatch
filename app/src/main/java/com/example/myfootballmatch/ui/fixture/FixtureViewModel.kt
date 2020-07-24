package com.example.myfootballmatch.ui.fixture

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.fixture.ApiFixture
import com.example.myfootballmatch.data.network.model.fixture.Fixture
import com.example.myfootballmatch.data.network.services.FixtureService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FixtureViewModel(private var fixtureService: FixtureService) : BaseViewModel(){

    var fixture: MutableLiveData<List<Fixture>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadFixtureNetwork() {
        setIsLoading(true)
        fixtureService.getFixtureFromTeamId(524)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(fixtures: List<Fixture>) {
        setIsLoading(false)
        fixture.value=fixtures
    }

    private var callback = object : Callback<ApiFixture> {
        override fun onResponse(@NonNull call: Call<ApiFixture?>, @NonNull response: Response<ApiFixture?>) {
            val fixtureResult: ApiFixture? = response.body()
            if (fixtureResult != null) {
                Log.d("asdakasas","result tidak null")

                setLeagues(fixtureResult.api.fixtures)
                Log.d("asdakasas", fixtureResult.api.fixtures[0].fixture_id.toString())
            } else {
                Log.d("asdakasas","result null")

                setLeagues(emptyList<Fixture>())
            }
        }

        override fun onFailure(
            call: Call<ApiFixture?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setLeagues(emptyList<Fixture>())
        }
    }

}