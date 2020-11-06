package com.example.learnmvvm.repository

import com.example.learnmvvm.data.response.DetailMatchResponse
import com.example.learnmvvm.domain.DetailMatchDomain
import com.example.learnmvvm.domain.TeamDomain
import io.reactivex.Single

interface DetailMatchRepository {

    fun getDetailMatchLeague(idEvent: String) : Single<List<DetailMatchDomain>>

    fun getLogoHome(idHome:String) : Single<List<TeamDomain>>

    fun getLogoAway(idAway:String) : Single<List<TeamDomain>>

}