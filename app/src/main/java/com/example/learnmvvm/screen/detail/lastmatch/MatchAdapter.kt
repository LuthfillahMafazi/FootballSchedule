package com.example.learnmvvm.screen.detail.lastmatch

import com.example.learnmvvm.R
import com.example.learnmvvm.domain.LastMatchDomain
import com.example.learnmvvm.screen.detail.detailmatch.DetailMatchActivity
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_match.view.*

class MatchAdapter (private val lastMatchDomain: LastMatchDomain) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {

        val strEvent = viewHolder.itemView.strEventItemMatchTV
        val strLeague = viewHolder.itemView.strLeagueItemMatchTV
        val intHomeScore = viewHolder.itemView.intHomeScoreItemMatchTV
        val intAwayScore = viewHolder.itemView.intAwayScoreItemMatchTV
        val date = viewHolder.itemView.dateEventItemMatchTV

        strEvent.text = lastMatchDomain.strEvent
        strLeague.text = lastMatchDomain.strLeague
        val homeScore = lastMatchDomain.intHomeScore
        val awayScore = lastMatchDomain.intAwayScore

        if (homeScore == null){
            intHomeScore.text = "0"
        } else {
            intHomeScore.text = awayScore
        }
        if (awayScore == null){
            intAwayScore.text = "0"
        } else {
            intAwayScore.text = awayScore
        }
        date.text = lastMatchDomain.dateEvent

        viewHolder.itemView.setOnClickListener {
            DetailMatchActivity.start(viewHolder.itemView.context, lastMatchDomain)
        }

//        viewHolder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailActivity::class.java)
//            intent.putExtra("id", lastMatchDomain.idEvent)
//            intent.putExtra("idHome", lastMatchDomain.idHomeTeam)
//            intent.putExtra("idAway", lastMatchDomain.idAwayTeam)
//            it.context.startActivity(intent)
//        }
    }

    override fun getLayout(): Int = R.layout.item_match
}