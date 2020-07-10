package com.example.myfootballmatch.country

import androidx.lifecycle.ViewModel
import com.example.myfootballmatch.country.model.Country
import com.example.myfootballmatch.network.ApiInterface
import com.example.myfootballmatch.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel: ViewModel() {
    private var apiInterface: ApiInterface = NetworkConfig.getNetworkFootballApi().create(ApiInterface::class.java)

    fun getListCountries(callback: CountriesCallBack){
        try {
            val call: Call<List<Country>> = apiInterface.getDataCountries()
            call.enqueue(object : Callback<List<Country>> {
                override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    callback.onFailure()
                }

                override fun onResponse(
                    call: Call<List<Country>>,
                    response: Response<List<Country>>
                ) {
                    callback.onSuccess(response.body()!!)
                }
            })
        }catch (e: Exception){

        }
    }


    interface CountriesCallBack {
        fun onSuccess(data: List<Country>)
        fun onFailure()
    }
}