package com.example.learnmvvm.repository

import com.example.learnmvvm.data.mapper.LastMatchMapper
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.domain.LastMatchDomain
import io.reactivex.Single

class NextMatchRepositoryImpl(
    private val service: GlobalService,
    private val mapper: LastMatchMapper
) : NextMatchRepository {
    override fun getNextMatchLeague(idLeague: String): Single<List<LastMatchDomain>> {
        return service.getNextMatchLeague(idLeague).map {
            mapper.mapToListDomain(it.events)
        }
    }
}