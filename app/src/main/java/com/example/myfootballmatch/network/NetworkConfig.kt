package com.example.myfootballmatch.network

import com.example.myfootballmatch.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getNetworkFootballApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): ApiInterface{
        return getNetworkFootballApi().create(ApiInterface::class.java)
    }
}
