package com.example.learnmvvm.repository

import com.example.learnmvvm.data.mapper.SearchMapper
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.domain.SearchDomain
import io.reactivex.Single

class SearchRepositoryImpl(
    private val service : GlobalService,
    private val searchMapper: SearchMapper
) : SearchRepository {
    override fun getSearchMatch(event: String): Single<List<SearchDomain>> {
        return service.getSearchMatch(event).map {
            searchMapper.mapToListDomain(it.event)
        }
    }
}