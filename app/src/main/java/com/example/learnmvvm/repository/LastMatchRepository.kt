package com.example.learnmvvm.repository

import com.example.learnmvvm.domain.LastMatchDomain
import io.reactivex.Single

interface LastMatchRepository {

    fun getLastMatchLeague(idLeague: String) : Single<List<LastMatchDomain>>

}