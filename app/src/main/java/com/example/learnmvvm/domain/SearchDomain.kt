package com.example.learnmvvm.domain

data class SearchDomain(
    val intSpectators: String? = null,
    val strEventAlternate: String? = null,
    val idEvent: String? = null,
    val strSport: String? = null,
    val strEvent: String? = null,
    val intRound: String? = null,
    val strDescriptionEN: String? = null,
    val intHomeScore: String? = null,
    val strHomeTeam: String? = null,
    val strFilename: String? = null,
    val strLeague: String? = null,
    val strAwayTeam: String? = null,
    val intAwayScore: String? = null,
    val idAPIfootball: Any? = null,
    val idLeague: String? = null,
    val idSoccerXML: Any? = null,
    val strSeason: String? = null,
    val dateEvent: String
)