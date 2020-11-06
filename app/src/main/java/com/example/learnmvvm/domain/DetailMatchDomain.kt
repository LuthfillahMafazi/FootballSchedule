package com.example.learnmvvm.domain

data class DetailMatchDomain(
    val idEvent:String,
    val strFilename: String,
    val idLeague:String,
    val strHomeTeam:String,
    val strAwayTeam:String,
    val intHomeScore:String,
    val intAwayScore:String,
    val strHomeGoalDetails:String,
    val strAwayGoalDetails: String,
    val strHomeLineupGoalkeeper:String,
    val strHomeLineupDefense:String,
    val strHomeLineupMidfield:String,
    val strHomeLineupForward:String,
    val strHomeLineupSubstitutes:String,
    val strAwayLineupGoalkeeper:String,
    val strAwayLineupDefense:String,
    val strAwayLineupMidfield:String,
    val strAwayLineupForward:String,
    val strAwayLineupSubstitutes:String
)