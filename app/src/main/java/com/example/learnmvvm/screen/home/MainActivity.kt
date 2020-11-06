package com.example.learnmvvm.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learnmvvm.R
import com.example.learnmvvm.data.model.FootballLeagueModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation.*

class MainActivity : AppCompatActivity() {

    var items: MutableList<FootballLeagueModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        setupRecyle()

    }

    private fun setupRecyle() {
        val layoutManagers = GridLayoutManager(this, 2)

        rv_league.apply {
            layoutManager = layoutManagers
            adapter = HomeAdapter(this@MainActivity, items)

        }
    }

    private fun loadData() {
        val id = resources.getStringArray(R.array.id_league)
        val foto = resources.obtainTypedArray(R.array.daftar_foto)
        val nama = resources.getStringArray(R.array.daftar_club)

        for (i in nama.indices) {
            items.add(
                FootballLeagueModel(
                    id[i],
                    foto.getResourceId(i, 0),
                    nama[i]
                )
            )

        }

        foto.recycle()
    }

    override fun onResume() {
        super.onResume()
//        footballAdapter.clear()
        loadData()
    }
}
