package com.example.myfootballmatch.network

import com.example.myfootballmatch.country.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiInterface {
    @Headers(
        "x-rapidapi-host: api-football-v1.p.rapidapi.com",
        "x-rapidapi-key: da2296771bmsh53b2c02cf954dd9p11db83jsnc23498be70d0",
        "useQueryString: true"
    )
    @GET("/countries")
    fun getDataCountries(): Call<List<Country>>



}