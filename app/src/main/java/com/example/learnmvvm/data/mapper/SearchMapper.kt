package com.example.learnmvvm.data.mapper

import com.example.learnmvvm.data.model.SearchModel
import com.example.learnmvvm.domain.SearchDomain

class SearchMapper : BaseMapper<SearchModel, SearchDomain> {
    override fun mapToDomain(model: SearchModel): SearchDomain {
        return SearchDomain(
            model.intSpectators,
            model.strEventAlternate,
            model.idEvent,
            model.strSport,
            model.strEvent,
            model.intRound,
            model.strDescriptionEN,
            model.intHomeScore,
            model.strHomeTeam,
            model.strFilename,
            model.strLeague,
            model.strAwayTeam,
            model.intAwayScore,
            model.idAPIfootball,
            model.idLeague,
            model.idSoccerXML,
            model.strSeason,
            model.dateEvent
        )
    }

    override fun mapToModel(domain: SearchDomain): SearchModel {
        return SearchModel(
            domain.intSpectators,
            domain.strEventAlternate,
            domain.idEvent,
            domain.strSport,
            domain.strEvent,
            domain.intRound,
            domain.strDescriptionEN,
            domain.intHomeScore,
            domain.strHomeTeam,
            domain.strFilename,
            domain.strLeague,
            domain.strAwayTeam,
            domain.intAwayScore,
            domain.idAPIfootball,
            domain.idLeague,
            domain.idSoccerXML,
            domain.strSeason,
            domain.dateEvent
        )
    }
}