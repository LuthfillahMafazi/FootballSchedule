package com.example.learnmvvm.data.mapper

import com.example.learnmvvm.data.model.TeamModel
import com.example.learnmvvm.domain.TeamDomain

class TeamMapper : BaseMapper<TeamModel, TeamDomain> {
    override fun mapToDomain(model: TeamModel): TeamDomain {
        return TeamDomain(
            model.idTeam,
            model.strTeamBadge
        )
    }

    override fun mapToModel(domain: TeamDomain): TeamModel {
        return TeamModel(
            domain.idTeam,
            domain.strTeamBadge
        )
    }
}