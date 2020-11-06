package com.example.learnmvvm.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class LastMatchDomain(
    val idEvent:String,
    val strEvent: String,
    val strFilename: String,
    val idLeague: String,
    val strLeague: String,
    val intHomeScore: String?,
    val intAwayScore: String?,
    val dateEvent: String,
    val idHomeTeam: String,
    val idAwayTeam: String
): Parcelable