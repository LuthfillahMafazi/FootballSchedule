package com.example.learnmvvm.repository

import com.example.learnmvvm.data.model.FootballDetailModel
import com.example.learnmvvm.domain.FootballDetailDomain
import io.reactivex.Single

interface FootballDetailRepository {

    fun getDetailLeague(idLeague: String) : Single<List<FootballDetailDomain>>

}