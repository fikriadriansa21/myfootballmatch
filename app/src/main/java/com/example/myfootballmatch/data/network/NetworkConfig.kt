package com.example.myfootballmatch.data.network

import com.example.myfootballmatch.BuildConfig
import com.example.myfootballmatch.data.network.services.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    private val logger = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val headerInterceptor = object: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val original : Request = chain.request()

            val request = original.newBuilder()
                .header("x-rapidapi-host","api-football-v1.p.rapidapi.com")
                .header("x-rapidapi-key","ada2296771bmsh53b2c02cf954dd9p11db83jsnc23498be70d0")
                .header("useQueryString","true")
                .method(original.method,original.body)
                .build()

            return chain.proceed(request)
        }
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)

    private val builder = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()

    val leagueService: LeagueService = builder.create(LeagueService::class.java)
    val fixtureService: FixtureService = builder.create(FixtureService::class.java)
    val standingService: StandingService = builder.create(StandingService::class.java)
    val playerService: PlayerService = builder.create(PlayerService::class.java)
    val topScoreService: TopScoreService = builder.create(TopScoreService::class.java)


}