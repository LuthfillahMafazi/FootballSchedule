package com.example.learnmvvm.data.mapper

import com.example.learnmvvm.data.model.DetailMatchModel
import com.example.learnmvvm.domain.DetailMatchDomain

class DetailMatchMapper : BaseMapper<DetailMatchModel, DetailMatchDomain> {
    override fun mapToDomain(model: DetailMatchModel): DetailMatchDomain {
        return DetailMatchDomain(
            model.idEvent,
            model.strFilename,
            model.idLeague,
            model.strHomeTeam,
            model.strAwayTeam,
            model.intHomeScore,
            model.intAwayScore,
            model.strHomeGoalDetails,
            model.strAwayGoalDetails,
            model.strHomeLineupGoalkeeper,
            model.strHomeLineupDefense,
            model.strHomeLineupMidfield,
            model.strHomeLineupForward,
            model.strHomeLineupSubstitutes,
            model.strAwayLineupGoalkeeper,
            model.strAwayLineupDefense,
            model.strAwayLineupMidfield,
            model.strAwayLineupForward,
            model.strAwayLineupSubstitutes
        )
    }

    override fun mapToModel(domain: DetailMatchDomain): DetailMatchModel {
        return DetailMatchModel(
            domain.idEvent,
            domain.strFilename,
            domain.idLeague,
            domain.strHomeTeam,
            domain.strAwayTeam,
            domain.intHomeScore,
            domain.intAwayScore,
            domain.strHomeGoalDetails,
            domain.strAwayGoalDetails,
            domain.strHomeLineupGoalkeeper,
            domain.strHomeLineupDefense,
            domain.strHomeLineupMidfield,
            domain.strHomeLineupForward,
            domain.strHomeLineupSubstitutes,
            domain.strAwayLineupGoalkeeper,
            domain.strAwayLineupDefense,
            domain.strAwayLineupMidfield,
            domain.strAwayLineupForward,
            domain.strAwayLineupSubstitutes
        )
    }
}