package com.example.myfootballmatch.country

import com.example.myfootballmatch.country.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface CountryService {
    @GET("/countries")
    fun getDataCountries(): Call<List<Country>>
}