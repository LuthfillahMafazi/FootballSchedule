package com.example.learnmvvm.data.mapper

import com.example.learnmvvm.data.model.FootballDetailModel
import com.example.learnmvvm.domain.FootballDetailDomain

class FootballDetailMapper: BaseMapper<FootballDetailModel, FootballDetailDomain> {
    override fun mapToDomain(model: FootballDetailModel): FootballDetailDomain {
        return FootballDetailDomain(
            model.idLeague,
            model.strLeague,
            model.intFormedYear,
            model.strCountry,
            model.strDescriptionEN,
            model.strLogo
        )
    }

    override fun mapToModel(domain: FootballDetailDomain): FootballDetailModel {
        return FootballDetailModel(
            domain.idLeague,
            domain.strLeague,
            domain.intFormedYear,
            domain.strCountry,
            domain.strDescriptionEN,
            domain.strLogo
        )
    }
}