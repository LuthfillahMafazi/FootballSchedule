package com.example.learnmvvm.repository

import com.example.learnmvvm.data.mapper.FootballDetailMapper
import com.example.learnmvvm.data.model.FootballDetailModel
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.domain.FootballDetailDomain
import io.reactivex.Single

class FootballDetailRepositoryImpl (
    private val service: GlobalService,
    private val mapper: FootballDetailMapper
) : FootballDetailRepository {
    override fun getDetailLeague(idLeague: String): Single<List<FootballDetailDomain>> {
        return service.getDetailLiga(idLeague).map {
            mapper.mapToListDomain(it.leagues)
        }
    }
}