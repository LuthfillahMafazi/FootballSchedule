package com.example.learnmvvm.data.service

import com.example.learnmvvm.data.response.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GlobalService {

    @GET("lookupleague.php?")
    fun getDetailLiga(@Query("id") idLeague:String) : Single<DetailResponse>

    @GET("eventspastleague.php?")
    fun getLastMatchLeague(@Query("id") idLeague: String) : Single<LastMatchResponse>

    @GET("eventsnextleague.php?")
    fun getNextMatchLeague(@Query("id") idLeague: String) : Single<NextMatchResponse>

    @GET("lookupevent.php?")
    fun getDetailMatchLeague(@Query("id") idEvent: String) : Single<DetailMatchResponse>

    @GET("searchevents.php?")
    fun getSearchMatch(@Query("e") event : String) : Single<SearchResponse>

    @GET("lookupteam.php?")
    fun getTeam(@Query("id") idTeam: String) : Single<TeamResponse>

}