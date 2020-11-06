package com.example.learnmvvm.repository

import com.example.learnmvvm.data.mapper.DetailMatchMapper
import com.example.learnmvvm.data.mapper.TeamMapper
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.domain.DetailMatchDomain
import com.example.learnmvvm.domain.TeamDomain
import io.reactivex.Single

class DetailMatchRepositoryImpl(
    private val service: GlobalService,
    private val mapper: DetailMatchMapper,
    private val teamMapper : TeamMapper
) : DetailMatchRepository {
    override fun getLogoHome(idHome: String): Single<List<TeamDomain>> {
        return service.getTeam(idHome).map {
            teamMapper.mapToListDomain(it.teams)
        }
    }

    override fun getLogoAway(idAway: String): Single<List<TeamDomain>> {
        return service.getTeam(idAway).map {
            teamMapper.mapToListDomain(it.teams)
        }
    }

    override fun getDetailMatchLeague(idEvent: String): Single<List<DetailMatchDomain>> {
        return service.getDetailMatchLeague(idEvent).map {
            mapper.mapToListDomain(it.events)
        }
    }
}