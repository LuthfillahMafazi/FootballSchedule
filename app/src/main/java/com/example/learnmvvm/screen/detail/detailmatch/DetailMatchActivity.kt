package com.example.learnmvvm.screen.detail.detailmatch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.learnmvvm.R
import com.example.learnmvvm.domain.LastMatchDomain
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import kotlinx.android.synthetic.main.item_match.*
import org.koin.android.ext.android.inject

class DetailMatchActivity : AppCompatActivity() {

    private val vm: DetailMatchVM by inject()
    private var lastMatchDomain: LastMatchDomain? = null

    var id = ""

    companion object {

        private const val EXT_DATA = "ext.data"

        fun start(context: Context, lastMatchDomain: LastMatchDomain?) {
            context.startActivity(
                Intent(context, DetailMatchActivity::class.java)
                    .putExtra(EXT_DATA, lastMatchDomain)

            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        vm.detailMatchState.observe(this, startObserver)
        lastMatchDomain = intent.getParcelableExtra(EXT_DATA)

//        id = lastMatchDomain?.idEvent.toString()
        lastMatchDomain?.idHomeTeam?.let { vm.getLogoHome(it) }
        lastMatchDomain?.idAwayTeam?.let { vm.getLogoAway(it) }
        lastMatchDomain?.idEvent?.let { vm.getDetailMatchLeague(it) }

    }

    private val startObserver = Observer<DetailMatchState>{onState ->
        when(onState) {

            is LogoHomeLoaded -> {
                Picasso.get().load(onState.teamDomain[0].strTeamBadge).into(img_home_badge)

            }

            is LogoAwayLoaded -> {
                Picasso.get().load(onState.teamDomain[0].strTeamBadge).into(img_away_badge)

            }

            is DetailMatchDataLoaded -> {
                onState.detailMatchDomain.forEach {
                    tv_date_event_details.text = it.strFilename
                    tv_home_team_details.text = it.strHomeTeam
                    tv_away_team_details.text = it.strAwayTeam
                    tv_home_goal_details.text = it.strHomeGoalDetails
                    tv_away_goal_details.text = it.strAwayGoalDetails
                    tv_home_goalKeeper.text = it.strHomeLineupGoalkeeper
                    tv_away_goalKeeper.text = it.strAwayLineupGoalkeeper
                    tv_home_defense.text = it.strHomeLineupDefense
                    tv_away_defense.text = it.strAwayLineupDefense
                    tv_home_midfield.text = it.strHomeLineupMidfield
                    tv_away_midfield.text = it.strAwayLineupMidfield
                    tv_home_forward.text = it.strHomeLineupForward
                    tv_away_forward.text = it.strAwayLineupForward
                    tv_home_substitutes.text = it.strHomeLineupSubstitutes
                    tv_away_substitutes.text = it.strAwayLineupSubstitutes

                }
            }
            is ErrorState -> {
                Toast.makeText(this, "Detail Failed To Load", Toast.LENGTH_LONG).show()

            }
        }
    }

}
