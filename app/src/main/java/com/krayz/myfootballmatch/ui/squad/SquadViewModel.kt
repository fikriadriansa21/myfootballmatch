package com.krayz.myfootballmatch.ui.squad

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.krayz.myfootballmatch.data.network.model.player.ApiPlayer
import com.krayz.myfootballmatch.data.network.model.player.Player
import com.krayz.myfootballmatch.data.network.services.PlayerService
import com.krayz.myfootballmatch.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SquadViewModel(private var playerService: PlayerService) : BaseViewModel(){

    var player: MutableLiveData<List<Player>> = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean>? = null

    init {
        isLoading = MutableLiveData()
    }


    fun loadPlayerNetwork(id: Int, season: String) {
        setIsLoading(true)
        playerService.getPlayerSquad(id,season).enqueue(callback)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading?.postValue(loading)
    }

    private fun setPlayerSquad(players: List<Player>) {
        setIsLoading(false)
        player.value=players
    }

    private var callback = object : Callback<ApiPlayer> {
        override fun onResponse(@NonNull call: Call<ApiPlayer?>, @NonNull response: Response<ApiPlayer?>) {
            val playerResult: ApiPlayer? = response.body()
            if (playerResult != null) {
                setPlayerSquad(playerResult.api.players)
            } else {
                setPlayerSquad(emptyList<Player>())
            }
        }

        override fun onFailure(
            call: Call<ApiPlayer?>,
            t: Throwable
        ) {
            Log.d("asdakasas","result failure")

            setPlayerSquad(emptyList<Player>())
        }
    }

}