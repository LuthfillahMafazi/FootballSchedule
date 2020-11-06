package com.example.learnmvvm.repository

import com.example.learnmvvm.data.mapper.LastMatchMapper
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.domain.LastMatchDomain
import io.reactivex.Single

class LastMatchRepositoryImpl(
    private val service: GlobalService,
    private val mapper: LastMatchMapper
) : LastMatchRepository {
    override fun getLastMatchLeague(idLeague: String): Single<List<LastMatchDomain>> {
        return service.getLastMatchLeague(idLeague).map {
            mapper.mapToListDomain(it.events)
        }
    }

}