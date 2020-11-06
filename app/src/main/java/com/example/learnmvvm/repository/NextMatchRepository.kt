package com.example.learnmvvm.repository

import com.example.learnmvvm.domain.LastMatchDomain
import io.reactivex.Single

interface NextMatchRepository {
    fun getNextMatchLeague(idLeague: String) : Single<List<LastMatchDomain>>
}