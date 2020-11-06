package com.example.learnmvvm.screen.detail.lastmatch


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.learnmvvm.R
import com.orhanobut.hawk.Hawk
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class LastMatchFragment : Fragment() {

    private val vm: LastMatchVM by inject()
    private val  lastMatchAdapter = GroupAdapter<ViewHolder>()

    var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.lastMatchState.observe(this, startObserver)

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_lastmatch.apply {
            layoutManager = linearLayoutManager
            adapter = lastMatchAdapter
        }

        id = Hawk.get("id","")
        vm.getLastMatchLeague(id)

    }

    private val startObserver = Observer<LastMatchState>{ onState ->
        when(onState) {
            is LastMatchDataLoaded -> {
                lastMatchAdapter.clear()
                onState.lastMatchDomain.map {
                    lastMatchAdapter.add(MatchAdapter(it))
                }
            }
            is ErrorState -> {
                Toast.makeText(context, "Failed To Load", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        vm.getLastMatchLeague(id)
    }

}
