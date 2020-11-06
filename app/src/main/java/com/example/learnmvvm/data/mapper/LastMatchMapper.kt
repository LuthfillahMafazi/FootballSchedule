package com.example.learnmvvm.data.mapper

import com.example.learnmvvm.data.model.LastMatchModel
import com.example.learnmvvm.domain.LastMatchDomain

class LastMatchMapper : BaseMapper<LastMatchModel, LastMatchDomain> {
    override fun mapToDomain(model: LastMatchModel): LastMatchDomain {
        return LastMatchDomain(
            model.idEvent,
            model.strEvent,
            model.strFilename,
            model.idLeague,
            model.strLeague,
            model.intHomeScore,
            model.intAwayScore,
            model.dateEvent,
            model.idHomeTeam,
            model.idAwayTeam
        )
    }

    override fun mapToModel(domain: LastMatchDomain): LastMatchModel {
        return LastMatchModel(
            domain.idEvent,
            domain.strEvent,
            domain.strFilename,
            domain.idLeague,
            domain.strLeague,
            domain.intHomeScore,
            domain.intAwayScore,
            domain.dateEvent,
            domain.idHomeTeam,
            domain.idAwayTeam
        )
    }
}