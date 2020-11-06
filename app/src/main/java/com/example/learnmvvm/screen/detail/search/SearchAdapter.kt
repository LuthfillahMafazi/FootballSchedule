package com.example.learnmvvm.screen.detail.search

import com.example.learnmvvm.R
import com.example.learnmvvm.domain.SearchDomain
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_match.view.*

class SearchAdapter (private val searchDomain: SearchDomain) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val strEvent = viewHolder.itemView.strEventItemMatchTV
        val strLeague = viewHolder.itemView.strLeagueItemMatchTV
        val intHomeScore = viewHolder.itemView.intHomeScoreItemMatchTV
        val intAwayScore = viewHolder.itemView.intAwayScoreItemMatchTV
        val date = viewHolder.itemView.dateEventItemMatchTV

        strEvent.text = searchDomain.strEvent
        strLeague.text = searchDomain.strLeague
        val homeScore = searchDomain.intHomeScore
        val awayScore = searchDomain.intAwayScore

        if (homeScore == null){
            intHomeScore.text = "0"
        } else {
            intHomeScore.text = awayScore
        }
        if (awayScore == null){
            intAwayScore.text = "0"
        } else {2
            intAwayScore.text = awayScore
        }
        date.text = searchDomain.dateEvent

    }

    override fun getLayout(): Int = R.layout.item_match
}