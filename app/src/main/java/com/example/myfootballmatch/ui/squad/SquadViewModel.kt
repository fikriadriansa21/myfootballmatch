package com.example.myfootballmatch.ui.squad

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myfootballmatch.data.network.model.player.ApiPlayer
import com.example.myfootballmatch.data.network.model.player.Player
import com.example.myfootballmatch.data.network.services.PlayerService
import com.example.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SquadViewModel(private var playerService: PlayerService) : BaseViewModel(){

    var player: MutableLiveData<List<Player>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadPlayerNetwork() {
        setIsLoading(true)
        playerService.getPlayerSquad(33,"2019-2020").enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setLeagues(players: List<Player>) {
        setIsLoading(false)
        player.value=players
    }

    private var callback = object : Callback<ApiPlayer> {
        override fun onResponse(@NonNull call: Call<ApiPlayer?>, @NonNull response: Response<ApiPlayer?>) {
            val playerResult: ApiPlayer? = response.body()
            if (playerResult != null) {
                Log.d("asdakasas","result tidak null")

                setLeagues(playerResult.api.players)
                Log.d("asdakasas",playerResult.api.players[0].player_name)
            } else {
                Log.d("asdakasas","result null")

                setLeagues(emptyList<Player>())
            }
        }

        override fun onFailure(
            call: Call<ApiPlayer?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setLeagues(emptyList<Player>())
        }
    }

}