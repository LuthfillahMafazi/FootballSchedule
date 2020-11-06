package com.example.learnmvvm.repository

import com.example.learnmvvm.domain.SearchDomain
import io.reactivex.Single

interface SearchRepository {

    fun getSearchMatch(event: String) : Single<List<SearchDomain>>

}