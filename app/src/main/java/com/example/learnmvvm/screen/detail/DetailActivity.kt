package com.example.learnmvvm.screen.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.example.learnmvvm.R
import com.example.learnmvvm.screen.detail.search.SearchMatchActivity
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private val vm: DetailVM by inject()

    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpViewPager()

        vm.detailState.observe(this, startObserver)

        id = intent.getStringExtra("idLeague")
        vm.getDetailleague(id)
        Hawk.put("id", id)

        search.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private val startObserver = Observer<FootballDetailState>{ onState ->
        when(onState) {
            is DetailDataLoaded -> {
                onState.footballDetailDomain.forEach {
                    titleDetailFragmentTV.text = it.strLeague + " " + "(" + it.intFormedYear + ")"
                    descriptionDetailFragmentTV.text = it.strDescriptionEN
                    countryDetailFragmentTV.text = it.strCountry
                    Picasso.get().load(it.strLogo).into(ligaDetailFragmentIV)

                }
            }
            is ErrorState -> {
                Toast.makeText(this, "Detail Failed To Load", Toast.LENGTH_LONG).show()

            }

        }

    }

    override fun onClick(v: View?) {
        v?.setOnClickListener {
              val intent = Intent(this, SearchMatchActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setUpViewPager() {
        val adapterVp = MainPagerAdapter(supportFragmentManager)
        detailFragmentVP.adapter = adapterVp
        detailFragmentVP.offscreenPageLimit = 2
        tabDetailFragmentTL.setupWithViewPager(detailFragmentVP)
    }
}
